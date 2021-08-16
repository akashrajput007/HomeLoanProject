package com.example.demo.Layer4;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Customer;

@Service
public interface ApplicationService {
	void insertApplicationService(Application application ,Customer customer );
	
//	void insertApplicationService(Application Ref);
	List<Application> selectAllApplicationService();
	Application selectApplicationService(Long CustId);
	void deleteApplicationService(Long custId);
	void updateStatusService(Long custId);
	void updateApplicationService(Long custId);
	Long getApplicationNoService(Customer customer);
}
