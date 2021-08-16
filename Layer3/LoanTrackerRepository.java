package com.example.demo.Layer3;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Application;


@Repository
public interface LoanTrackerRepository {
	Application getStatus(Long ApplicationNo,String Mobile);
}

