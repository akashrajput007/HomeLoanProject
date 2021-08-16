package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Emi;
import com.example.demo.Layer3.EMIRepositoryImpl;

@Service
public class EmiServiceImp implements EmiService{

	@Autowired
	EMIRepositoryImpl emiRepo;
	@Override
	public void insertEMIService(Long custId) {
		System.out.println("Insert Emi Service called ");
		emiRepo.insertEMI(custId);
		
	}
  
	@Override
	public List<Emi> selectEMIService(Long custId) {
		
		return emiRepo.selectEMI(custId);
		
	}
}