package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.ApplicationNotFoundException;

@Repository
public interface ApplicationRepository {
	void insertApplication(Application Ref);
	List<Application> selectAllApplication();
	Application getApplicationByCustID(Long CustId);
	public Long getApplicationNo(Customer customer);
	void deleteApplication(Long CustId) throws ApplicationNotFoundException;
	void updateStatus(Long custId) throws ApplicationNotFoundException;
	void updateApplication(Long custId) throws ApplicationNotFoundException;
}
