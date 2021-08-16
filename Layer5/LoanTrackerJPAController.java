package com.example.demo.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer4.LoanTrackerServiceImpl;
import com.example.demo.Layer2.Application;

@CrossOrigin(origins = "*")
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/loanTracker")
public class LoanTrackerJPAController {
	@Autowired
	LoanTrackerServiceImpl loanService;
	
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getApplication/{applicationNo}/{mobileNo}")
	public Application getStatus(@PathVariable Long applicationNo,@PathVariable String mobileNo) {
		return loanService.getStatus(applicationNo, mobileNo);
	}

}
