package com.example.demo.Layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Employment;
import com.example.demo.Layer4.EmploymentService;

@CrossOrigin
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/employment")
public class EmploymentJPAController {
	

	@Autowired
	EmploymentService AddEmploymentService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/test")
	String test() {
		return "OK"; //connect to the DB also via spring JPA
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllEmployment")			
	public List<Employment> getAllEmployment() {
		System.out.println("getAllEmployment()called");
		return AddEmploymentService.getAllEmploymentService();
	
	}
}
