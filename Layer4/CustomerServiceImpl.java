package com.example.demo.Layer4;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.CustomerRepositoryImpl;
import com.example.demo.Layer3.Exceptions.CustomerNotFoundException;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired 
	CustomerRepositoryImpl custRepo; 
	
	@Override
	public Customer insertCustomerService(Customer cust) {
	   
	  System.out.println("Customer Service method...");
	  return custRepo.insertCustomer(cust);
	}
	@Override
	public Customer selectCustomerService(Long custId) {
		return custRepo.selectCustomer(custId);
		
	}
	@Override
	public List<Customer> selectAllCustomerService() {
		return custRepo.selectAllCustomer();
		
	}
	@Override
	public void deleteCustomerService(Long custId) {
		try {
			custRepo.deleteCustomer(custId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public Customer selectCustomerByEmailService(String emailId) {
		try {
			return custRepo.selectCustomerByEmail(emailId);
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
    
}
