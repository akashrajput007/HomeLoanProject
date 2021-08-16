package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.ApplicationNotFoundException;

@Service
public interface AddressService {
	void insertAddressService(Address address , Customer customer);
//	void insertAddressService(Address Ref);
	List<Address> selectAllAddressService();
	public Address selectAddressByCustIDService(Long CustID) throws ApplicationNotFoundException;
	void deleteAddressService(Long custId);
	
	
	//remove this method later
//	List<Customer> selectAllCustService();
	
}
