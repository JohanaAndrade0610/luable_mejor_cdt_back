# ---------- build stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /workspace

# copy only build files first for dependency caching
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp -DskipTests dependency:go-offline

# copy source and build
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -B -ntp -DskipTests package

# grab the final jar
ARG JAR_FILE=target/*.jar
RUN cp $(ls -1 $JAR_FILE | head -n 1) /workspace/app.jar

# ---------- runtime stage ----------
FROM eclipse-temurin:21-jre-alpine
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser
WORKDIR /home/appuser

COPY --from=builder /workspace/app.jar ./app.jar

ENV JAVA_OPTS="-Xms256m -Xmx512m -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom"

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=10s --retries=3 \
  CMD wget -qO- --no-check-certificate http://localhost:8080/actuator/health || exit 1

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar app.jar" ]
