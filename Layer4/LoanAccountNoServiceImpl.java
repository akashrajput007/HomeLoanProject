package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Loan;
import com.example.demo.Layer3.LoanAccountNoRepositoryImpl;


@Repository
public class LoanAccountNoServiceImpl {
	
	@Autowired 
	LoanAccountNoRepositoryImpl LoanNo;
	
	public LoanAccountNoServiceImpl() {
		System.out.println("LoanAccountNoServiceImpl() constructed...");
	}
	
	public List<Loan> getNo(Long applicationNo) {
		return LoanNo.getNo(applicationNo);
	}
}
