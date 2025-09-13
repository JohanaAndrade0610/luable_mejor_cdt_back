package org.implementer.demo.investapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserInvestmentDTO {

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "user_image_url")
    private String userImageUrl;

    @JsonProperty(value = "user_identification")
    private String identification;

    @JsonProperty(value = "bank_name")
    private String bankName;

    @JsonProperty(value = "amount")
    private BigDecimal amount;

    @JsonProperty(value = "rate")
    private String rate;

    @JsonProperty(value = "start_date")
    private String startDate;
    @JsonProperty(value = "end_date")
    private String endDate;

    @JsonProperty(value = "roi")
    private BigDecimal roi;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getRoi() {
        return roi;
    }

    public void setRoi(BigDecimal roi) {
        this.roi = roi;
    }

    public UserInvestmentDTO(Long userId, String userImageUrl, String identification, String bankName, BigDecimal amount, BigDecimal rate, LocalDate startDate, LocalDate endDate, BigDecimal roi) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.userId = userId;
        this.userImageUrl = userImageUrl;
        this.identification = identification;
        this.bankName = bankName;
        this.amount = amount;
        this.rate = rate.toString() + "%";
        this.startDate = dtf.format(startDate);
        this.endDate = dtf.format(endDate);
        this.roi = roi;
    }
}
