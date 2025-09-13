package org.implementer.demo.investapi.repository;

import org.implementer.demo.investapi.dtos.UserInvestmentDTO;
import org.implementer.demo.investapi.entity.UserInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInvestmentRepository extends JpaRepository<UserInvestment, Long> {

    @Query("SELECT new org.implementer.demo.investapi.dtos.UserInvestmentDTO(u.userId, u.userImageUrl, u.identification, ui.bankName, ui.amount, ui.rate, ui.startDate, ui.endDate, ui.roi) "+
    "FROM UserInvestment ui " +
    "JOIN ui.user u "+
    "WHERE ( (:identification IS NULL) OR :identification = u.identification)")
    List<UserInvestmentDTO> findByUserId(@Param("identification") String identification);
}
