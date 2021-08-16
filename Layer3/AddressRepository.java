package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.AddressNotFoundException;

@Repository
public interface AddressRepository{
	
	void insertAddress(Address Ref);
	List<Address> selectAllAddress();
	public Address selectAddressByCustID(Long custId) throws AddressNotFoundException; 
	public void deleteAddress(Long custId) throws AddressNotFoundException;
}
