package com.example.demo.Layer4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Admin;

import com.example.demo.Layer3.AdminValidationRepositoryImpl;


@Service
public class AdminValidationServiceImpl {
	
@Autowired
AdminValidationRepositoryImpl AdminVal;

public Admin getValidation(String username,String password) {
	return AdminVal.getValidation(username, password);
}

}
