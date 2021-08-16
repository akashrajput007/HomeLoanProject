package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;

@Service
public interface CustomerService {
  public Customer insertCustomerService(Customer cust);
  public Customer selectCustomerService(Long custId);
  public List<Customer> selectAllCustomerService();
  public void deleteCustomerService(Long custId);
  public Customer selectCustomerByEmailService(String emailId);
}
