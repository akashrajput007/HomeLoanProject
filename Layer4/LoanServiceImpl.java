package com.example.demo.Layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Loan;
import com.example.demo.Layer3.LoanInsertRepositoryImpl;
import com.example.demo.Layer3.LoanRepository;
//import com.example.demo.Layer3.LoanRepository;


@Service
public class LoanServiceImpl implements LoanService {


	@Autowired 
	LoanRepository loanRepository;
//	
	@Autowired
	LoanInsertRepositoryImpl loanInsertRepo;
//	@Override
//	public Long getBalance(Long loanAccNo) {
//		// TODO Auto-generated method stub
//		Long balance = loanRepository.getBalance(loanAccNo);
//		return balance;
//	}
	
	
	
	@Override
	public Long getBalance(Long LOAN_ACC_NO) {
		// TODO Auto-generated method stub
		Long balance = loanRepository.getBalance(LOAN_ACC_NO);
		return balance;
	}

	
	@Override
	public void insertLoanService(Long custId) {
		
		loanInsertRepo.insertLoan(custId);
		
	}
	

	@Override
	public Loan selectLoanService(Long custId) {
		
		return loanInsertRepo.selectLoan(custId);
	}
	

}