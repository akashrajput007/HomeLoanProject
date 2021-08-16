package com.example.demo.Layer4;



import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Property;

@Service
public interface PropertyService {
	public void insertPropertyService(Property property , Customer customer);
//	public void insertPropertyService(Property property);
	public Property selectPropertyService(Long custId);
	  public List<Property> selectAllPropertyService();
	  public void deletePropertyService(Long custId);
	  
	  
	  


	
}
