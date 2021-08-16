package com.example.demo.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer4.LoanService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

@RequestMapping("/fetechBalance")
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@GetMapping("/{number}")
	public Long fetchBalance(@PathVariable("number") Long loanAccNo) {
		Long balance = loanService.getBalance(loanAccNo);
		return balance;
	}
	

}