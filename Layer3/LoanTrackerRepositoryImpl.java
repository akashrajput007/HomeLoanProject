package com.example.demo.Layer3;


import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Layer2.Application;

import com.example.demo.Layer2.Customer;


@Repository
public class LoanTrackerRepositoryImpl extends BaseRepository implements LoanTrackerRepository{
	
	@Transactional
	public Application getStatus(Long ApplicationNo, String Mobile) {
		EntityManager entityManager = getEntityManager();
		Application app = entityManager.find(Application.class, ApplicationNo);
		Customer cust = app.getCustomer();
		System.out.println(cust.getPhoneNumber());
		if(cust.getPhoneNumber().equals(Mobile)) {
			if (app != null)
				return app;	
		}
		
		return null;	
	}
}