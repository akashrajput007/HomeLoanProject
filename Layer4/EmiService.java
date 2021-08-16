package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Emi;

@Service
public interface EmiService {
   public void insertEMIService(Long custId);
   public List<Emi> selectEMIService(Long custId);
}