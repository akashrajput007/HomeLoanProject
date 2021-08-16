package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.CustomerNotFoundException;



@Repository
public interface CustomerRepository {
   public Customer insertCustomer(Customer cust);
   public Customer selectCustomer(Long custId);
   public List<Customer> selectAllCustomer(); 
   public void deleteCustomer(Long custId) throws CustomerNotFoundException;
   public Customer selectCustomerByEmail(String emailId) throws CustomerNotFoundException;
}
