package com.example.demo.Layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer4.AddressServiceImpl;



@CrossOrigin
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/address")
public class AddressJPAController {
	
	@Autowired
	AddressServiceImpl AddService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/test")
	String test() {
		return "OK"; //connect to the DB also via spring JPA
	}

	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllAddress")			
	public List<Address> getAllAddress() {
		System.out.println("getAllAddress() called");
		return AddService.selectAllAddressService();	
	}
	
	@GetMapping(value = "/getAddressByCustID/{CustId}")	
	public Address getAddressByCustID(@PathVariable Long CustId) {
			System.out.println("called getAddressByCustID() layer 5");
			return AddService.selectAddressByCustIDService(CustId);
	}
		
}
