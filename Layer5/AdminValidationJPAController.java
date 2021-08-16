package com.example.demo.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Admin;
import com.example.demo.Layer4.AdminValidationServiceImpl;


@CrossOrigin(origins = "*")
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/adminVal")
public class AdminValidationJPAController {
	@Autowired
	AdminValidationServiceImpl adminService;
	
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAdmin/{username}/{password}")
	public Admin getValidation(@PathVariable String username,@PathVariable String password) {
		return adminService.getValidation(username, password);
	}
}