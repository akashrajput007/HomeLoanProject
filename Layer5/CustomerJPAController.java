package com.example.demo.Layer5;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer4.CustomerServiceImpl;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/cust")
public class CustomerJPAController {
	@Autowired 
	CustomerServiceImpl CustService;
  
    public CustomerJPAController(CustomerServiceImpl custService) {
		super();
		System.out.println("CustomerJPA Controller Constructed..");
    }
    
    @GetMapping
    @ResponseBody
    @RequestMapping("/test")
    public void testing() {
    	System.out.println("Hello");
    }
    
    @GetMapping
    @ResponseBody
    @RequestMapping("/getCust/{custId}")
    public Customer getCustomer(@PathVariable Long custId) {
    	System.out.println("selecting customer..");
    	return CustService.selectCustomerService(custId);
    }
    
    @GetMapping
    @ResponseBody
    @RequestMapping("/getAllCust")
    public List<Customer> getAllCustomer() {
    	System.out.println("selecting customer..");
    	return CustService.selectAllCustomerService();
    }
    
	@PostMapping("/addCust")
	public Customer addEmployee(@RequestBody Customer customer) {
		System.out.println("addEmployee()...method ");
        System.out.println(customer.getCustId());
        return CustService.insertCustomerService(customer);

     }
	
	@ResponseBody
	@DeleteMapping(value = "/deleteAllDetails/{custId}")
	public void deleteEmployee(@PathVariable Long custId) {
	    CustService.deleteCustomerService(custId);
	    System.out.println("All Details are Deleted");
	}
  }
