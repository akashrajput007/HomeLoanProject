package com.example.demo.Layer4;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Admin;
@Service
public interface AdminValidationService{
	public Admin getValidation(String username, String password);
}