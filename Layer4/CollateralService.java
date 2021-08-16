package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Collateral;
import com.example.demo.Layer2.Customer;

@Service
public interface CollateralService {
	void insertCollateralService(Collateral collateral , Customer customer);

//	void insertCollateralService(Collateral Ref);
	List<Collateral> selectAllCollateralService();
	Collateral selectCollateralByCustIDService(Long CustId);
}
