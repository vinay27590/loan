package com.store.loan.service;

import com.store.loan.entity.Loan;
import com.store.loan.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    public Loan saveLoan(Loan loan){
        if (validateLoan(loan)){
            System.out.println("payment date is greater than due date");
            throw new IllegalArgumentException("Payment date cannot be greater than the due date.");
        }
        else {
            return loanRepository.save(loan);
        }

    }

    public Loan getLoanById(String id){
        return loanRepository.findById(id).orElse(null);
    }

    public List<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    public void deleteLoanById(String id){
         loanRepository.deleteById(id);
    }

    private boolean validateLoan(Loan loan){
        if(!loan.getPaymentDate().isBefore(loan.getDueDate())){
            return true;
        }
        else {
            return false;
        }
    }

    public Long remainingAmountByLenderId(String lenderId){
       return getAllLoans().stream().filter(loan -> loan.getLenderId().equalsIgnoreCase(lenderId)).mapToLong(loan -> loan.getRemainingAmount()).sum();
    }

    public Long remainingAmountByCustomerId(String customerId){
        return getAllLoans().stream().filter(loan -> loan.getCustomerId().equalsIgnoreCase(customerId)).mapToLong(loan -> loan.getRemainingAmount()).sum();
    }

    public List<Loan> dueDateCrossedLoans(){
        return getAllLoans().stream().filter(loan -> loan.getDueDate().isBefore(LocalDate.now())).collect(Collectors.toList());
    }

}
