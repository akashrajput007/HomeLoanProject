package com.example.demo.Layer4;

public interface CustomerDetailsService {
	
	public String validate(String email,String password);
	
	public String updatePassword(Long cust_id);
	
	public String newPasswordUpdate(Long cust_id,String password);

}