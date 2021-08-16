package com.example.demo.Layer4;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Property;
import com.example.demo.Layer3.PropertyRepositoryImpl;
import com.example.demo.Layer3.Exceptions.PropertyNotFoundException;

@Service
public class PropertyServiceImpl implements PropertyService{
 
	@Autowired
	PropertyRepositoryImpl propertyRepo;
	
	@Override
	public void insertPropertyService(Property property , Customer customer) {
		System.out.println("Property Service Called");
		//business Logic to be written
		System.out.println("--------------------------------------------------------------");
		System.out.println(customer);
		
		property.setCustomer(customer);
		System.out.println("customer object is set in property");
		System.out.println("property.getCustomer() to check whether customer is set or not in property" + property.getCustomer());
		propertyRepo.insertProperty(property);
		
	}
	
//	@Override
//	public void insertPropertyService(Property property) {
//		System.out.println("Property Service Called");
//		propertyRepo.insertProperty(property);
//	}

	@Override
	public Property selectPropertyService(Long custId) {
		return propertyRepo.selectProperty(custId);
		
		
		
	}
	@Override
	public List<Property> selectAllPropertyService() {
		 return  propertyRepo.selectAllProperty();
	}
	
	@Override
	public void deletePropertyService(Long custId) {
		try {
			propertyRepo.deleteProperty(custId);
		} catch (PropertyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
