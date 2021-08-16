package com.example.demo.Layer4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.CustomerDetails;

@Service
public class CustomerDetailsImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetails customerDetails;

	@Override
	public String validate(String email, String password) {

		Customer findByEmail = customerDetails.findByEmail(email);
		if (findByEmail != null) {
			String password2 = findByEmail.getPassword();
			if (password2.equals(password)) {
				return "Success";
			} else {
				return "Password Mismatch";
			}
		}

		return "User Doesn't Exist";
	}

	@Override
	public String updatePassword(Long cust_id) {
		Customer customer = customerDetails.updatePassword(cust_id);
		if(customer!=null) {
			return "Customer exist";
		}
		return "Customer doesn't exist";
	}

	@Override
	public String newPasswordUpdate(Long cust_id,String password) {
		Customer customer = customerDetails.updatePassword(cust_id);
		customer.setPassword(password);
		customerDetails.save(customer);
		return "Password Updated Successfully";
	}

}