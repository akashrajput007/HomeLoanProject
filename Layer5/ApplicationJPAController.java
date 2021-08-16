package com.example.demo.Layer5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Layer2.Application;
import com.example.demo.Layer4.ApplicationServiceImpl;

@CrossOrigin
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/application")
public class ApplicationJPAController {
	
	@Autowired
	ApplicationServiceImpl AppService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/test")
	String test() {
		return "OK"; //connect to the DB also via spring JPA
	}

//	@PostMapping(value="/data")
//	public String addCustAddress(@RequestBody Application app ) {
//		AppService.insertApplicationService(app);
//		return "Address Added Successfully";	
//	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllApplication")			
	public List<Application> getAllApplication() {
		System.out.println("getAllAddress() called");
		return AppService.selectAllApplicationService();
	}
	
	@GetMapping(value = "/getApplicationByCustID/{CustId}")	
	public Application getApplicationByCustID(@PathVariable Long CustId) {
			System.out.println("called getApplicationByCustID() layer 5");
			return AppService.selectApplicationService(CustId);		
	
	}
	
	@ResponseBody
	@GetMapping(value="/updateStatus/{custId}")
	public void updateStatus(@PathVariable Long custId) {
		System.out.println(custId);
	   	AppService.updateStatusService(custId);
	}
}
