package com.example.demo.Layer4;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Application;
@Repository
public interface LoanTrackerService {
	public Application getStatus(Long applicationNo,String mobileNo);
	
}
