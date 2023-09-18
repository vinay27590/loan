package com.store.loan.controller;


import com.store.loan.entity.Loan;
import com.store.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    LoanService loanService;

    @GetMapping("/getAllLoans")
    public List<Loan> getAllLoans(){
        return loanService.getAllLoans();
    }

    @GetMapping("/getLoanById/{id}")
    public Loan getLoanById(@PathVariable String id){
        return loanService.getLoanById(id);
    }

    @PostMapping("/saveLoan")
    public Loan saveLoan(@RequestBody Loan loan){
        return loanService.saveLoan(loan);
    }

    @DeleteMapping("/deleteLoanById/{id}")
    public void deleteLoanById(@PathVariable String id){
        loanService.deleteLoanById(id);
    }

    @GetMapping("/getAggregatedRemainingAmountByCustomerId/{customerId}")
    public Long getAggregatedRemainingAmountByCustomerId(@PathVariable String customerId){
        return loanService.remainingAmountByCustomerId(customerId);
    }

    @GetMapping("getAggregatedRemainingAmountByLenderId/{lenderId}")
    public Long getAggregatedRemainingAmountByLenderId(@PathVariable String lenderId){
        return loanService.remainingAmountByLenderId(lenderId);
    }

    @GetMapping("/getAllDueDateCrossedLoans")
    public List<Loan> getAllDueDateCrossedLoans(){
        return loanService.dueDateCrossedLoans();
    }


}
