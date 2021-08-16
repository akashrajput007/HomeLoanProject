package com.example.demo.Layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Collateral;
import com.example.demo.Layer4.CollateralService;

@CrossOrigin
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/collateral")
public class CollateralJPAController {
	
	@Autowired
	CollateralService ColService;
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value = "/test")
	String test() {
		return "OK"; //connect to the DB also via spring JPA
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllCollateral")			
	public List<Collateral> getAllCollateral() {
		System.out.println("getAllCollateral() called");
		return ColService.selectAllCollateralService();
	
	}
	
	@GetMapping(value = "/getColByCustID/{CustId}")	
	public Collateral getCollateralByCustID(@PathVariable Long CustId) {
		System.out.println("getCollateralByCustID() called ");
			return ColService.selectCollateralByCustIDService(CustId);
		
	}
	
}
