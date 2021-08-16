package com.example.demo.Layer3;


import java.util.List;

import com.example.demo.Layer2.Loan;

public interface LoanAccountNoRepository {
	List<Loan> getNo(Long ApplicationNo);
}
