package com.example.demo.Layer4;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Collateral;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.CollateralRepositoryImpl;

@Service
public class CollateralServiceImpl implements CollateralService {

	@Autowired
	CollateralRepositoryImpl AddCol;
	
	@Override
	public void insertCollateralService(Collateral collateral , Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("insertCollateralService(Collateral Ref) : Layer 4");
		collateral.setCustomer(customer);
		AddCol.insertCollateral(collateral);
	}

	
//	@Override
//	public void insertCollateralService(Collateral Ref) {
//		// TODO Auto-generated method stub
//		System.out.println("insertCollateralService(Collateral Ref) : Layer 4");
//		AddCol.insertCollateral(Ref);
//	}

	@Override
	public List<Collateral> selectAllCollateralService() {
		// TODO Auto-generated method stub
		System.out.println("selectAllCollateralService(): Layer 4");
		return AddCol.getAllCollateral();
	}

	@Override
	public Collateral selectCollateralByCustIDService(Long CustId) {
		// TODO Auto-generated method stub
		System.out.println("selectCollateralByCustIDService(Integer CustId)");
		return AddCol.getCollateralByCustID(CustId);
	}

}
