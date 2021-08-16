package com.example.demo.Layer3;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Admin;
@Repository
public interface AdminValidationRepository {
	Admin getValidation(String username,String password);
}