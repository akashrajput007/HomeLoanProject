package com.example.demo.Layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer4.LoanAccountNoServiceImpl;
import com.example.demo.Layer2.Loan;

@CrossOrigin(origins = "*")
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/LoanAccountNo")
public class LoanAccountNoJPAController {
	
	@Autowired
	LoanAccountNoServiceImpl loanService;
	public LoanAccountNoJPAController() {
		System.out.println("LoanAccountNoJPAController() constructed...");
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getLoanAccountNo/{applicationNo}")
	public List<Loan> getNo(@PathVariable Long  applicationNo) {
		return loanService.getNo(applicationNo);
	}

}

