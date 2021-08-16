package com.example.demo.Layer5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Property;
import com.example.demo.Layer4.PropertyServiceImpl;

@RestController
@RequestMapping("/property")
public class PropertyJPAController {
	
    @Autowired
    PropertyServiceImpl propertyService;
    
	@GetMapping("/getProperty/{custId}")
	public Property getProperty(@PathVariable Long custId) {
		return propertyService.selectPropertyService(custId);
	}
}
