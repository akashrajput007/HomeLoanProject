//package com.example.demo.Layer4;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public interface LoanService {
//	//public Long getBalance(Long loanAccNo);
//	public void insertLoanService(Long custId);
//
//}

package com.example.demo.Layer4;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Loan;

@Service
public interface LoanService {
	public Long getBalance(Long LOAN_ACC_NO);
	public void insertLoanService(Long custId);
	public Loan selectLoanService(Long custId);
	

}