package com.example.demo.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer4.CustomerDetailsService;
@CrossOrigin("*")
@RestController
@RequestMapping("/validation")
public class CustomerController {
	
	@Autowired
	CustomerDetailsService customerDetailsService;
	
	@PostMapping("/userLogin")
	public String validate(@RequestBody Customer customer) {
		return customerDetailsService.validate(customer.getEmailId(), customer.getPassword());
		
	}
	
	@GetMapping("/forgotPassword/{cust_id}")
	public String updatePassword(@PathVariable("cust_id") Long cust_id) {
		String updatePassword = customerDetailsService.updatePassword(cust_id);
		return updatePassword;
	}
	
	@PutMapping("/newPassword/{cust_id}/{password}")
	public String newPasswordUpdate(@PathVariable("cust_id") Long cust_id,@PathVariable("password") String password) {
		return customerDetailsService.newPasswordUpdate(cust_id, password);
		
	}

}
