package com.example.demo.Layer4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer3.LoanTrackerRepositoryImpl;

@Service
public class LoanTrackerServiceImpl {
	
	@Autowired
	LoanTrackerRepositoryImpl LoanRepo;
	
	public Application getStatus(Long applicationNo,String mobileNo) {
		return LoanRepo.getStatus(applicationNo, mobileNo);
	}

}