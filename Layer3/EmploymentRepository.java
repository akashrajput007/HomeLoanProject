package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Employment;
import com.example.demo.Layer3.Exceptions.EmploymentNotFoundException;

@Repository
public interface EmploymentRepository {
	public void insertEmployment(Employment Ref);	
	public List<Employment> getAllEmployment();
	public void deleteEmployment(Long custId) throws EmploymentNotFoundException;
}
