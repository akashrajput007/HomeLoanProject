package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Employment;

@Service
public interface EmploymentService {
	void insertEmploymentService(Employment employment , Customer customer);
//	void insertEmploymentService(Employment Ref);
	List<Employment> getAllEmploymentService();
	 public void deleteEmploymentService(Long custId);
}
