package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Emi;

@Repository
public interface EMIRepository {
   public void insertEMI(Long custId);
   public List<Emi> selectEMI(Long custId);
}