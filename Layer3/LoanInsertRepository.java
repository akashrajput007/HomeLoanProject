package com.example.demo.Layer3;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Loan;

@Repository
public interface LoanInsertRepository {
  public void insertLoan(Long custId);
  public Loan selectLoan(Long custId);
}