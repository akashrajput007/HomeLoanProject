package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Employment;
import com.example.demo.Layer3.EmploymentRepository;
import com.example.demo.Layer3.Exceptions.EmploymentNotFoundException;


@Service
public class EmploymentServiceImpl implements EmploymentService {

	@Autowired
	EmploymentRepository EmpRepo;
	
	@Override
	public void insertEmploymentService(Employment employment , Customer customer) {
		// TODO Auto-generated method stub
		employment.setCustomer(customer);
		EmpRepo.insertEmployment(employment);
		
	}

	
//	@Override
//	public void insertEmploymentService(Employment Ref) {
//		// TODO Auto-generated method stub
//		EmpRepo.insertEmployment(Ref);	
//	}

	@Override
	public List<Employment> getAllEmploymentService() {
		// TODO Auto-generated method stub
		return EmpRepo.getAllEmployment();
	}
	
	@Override
	public void deleteEmploymentService(Long custId) {
		try {
			EmpRepo.deleteEmployment(custId);
		} catch (EmploymentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
