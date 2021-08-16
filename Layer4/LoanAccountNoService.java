package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Loan;

@Repository
public interface LoanAccountNoService {
	public List<Loan> getNo(Long  applicationNo);
}
