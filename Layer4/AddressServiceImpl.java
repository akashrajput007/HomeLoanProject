package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.Customer;

import com.example.demo.Layer3.AddressRepositoryImpl;
import com.example.demo.Layer3.Exceptions.AddressNotFoundException;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepositoryImpl AddRepo;
	
	@Override
	public void insertAddressService(Address address , Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("AddressServiceImpl: Layer 4");
		address.setCustomer(customer);
		System.out.println("--------------------------------------------------------------");
		System.out.println("customer object is saved in address");
		System.out.println("address.getcustomer() to check whether address is set or not" + address.getCustomer());
		AddRepo.insertAddress(address);
		System.out.println("--------------------------------------------------------------");

	}

	@Override
	public List<Address> selectAllAddressService() {
		// TODO Auto-generated method stub
		System.out.println("AddressServiceImpl(select all address): Layer 4");
		return AddRepo.selectAllAddress();
	}

	public Address selectAddressByCustIDService(Long custId) {
		// TODO Auto-generated method stub
		try {
			System.out.println("AddressServiceImpl(select address By CustID): Layer 4");
			return AddRepo.selectAddressByCustID(custId);
		}
		catch(AddressNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAddressService(Long custId) {
		try {
			AddRepo.deleteAddress(custId);
		} catch (AddressNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
