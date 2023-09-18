package com.store.loan.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "LOAN")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Loan {

    @Id
    @Column(name = "LOAN_ID" , nullable = false)
    private String loanId;

    @Column(name = "CUSTOMER_ID",nullable = false)
    private String customerId;

    @Column(name = "LENDER_ID" ,nullable = false)
    private String lenderId;

    @Column(name = "AMOUNT" ,nullable = false)
    private Long amount;

    @Column(name = "REMAINING_AMOUNT" ,nullable = false)
    private Long remainingAmount;

    @Column(name = "PAYMENT_DATE" ,nullable = false)
    private LocalDate paymentDate;

    @Column(name = "DUE_DATE" ,nullable = false)
    private LocalDate dueDate;

    @Column(name = "INTEREST_PER_DAY" ,nullable = false)
    private Double interestPerDay;

    @Column(name = "PENALTY_PER_DAY" ,nullable = false)
    private Double penaltyPerDay;

    @Column(name = "CANCEL")
    private Boolean cancel;

}
