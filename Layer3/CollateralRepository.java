package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Collateral;

@Repository
public interface CollateralRepository {
	void insertCollateral(Collateral Ref);
	List<Collateral> getAllCollateral();
	Collateral getCollateralByCustID(Long CustId);
}
