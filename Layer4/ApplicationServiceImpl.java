package com.example.demo.Layer4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.ApplicationRepositoryImpl;
import com.example.demo.Layer3.Exceptions.ApplicationNotFoundException;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationRepositoryImpl AppRepo;
	
	@Override
	public void insertApplicationService(Application application , Customer customer) {
		// TODO Auto-generated method stub
		application.setCustomer(customer);
		AppRepo.insertApplication(application);
	}

	
//	@Override
//	public void insertApplicationService(Application Ref) {
//		// TODO Auto-generated method stub
//		AppRepo.insertApplication(Ref);
//	}

	@Override
	public List<Application> selectAllApplicationService() {
		// TODO Auto-generated method stub
		return AppRepo.selectAllApplication();		
	}


	@Override
	public Application selectApplicationService(Long CustId) {
		// TODO Auto-generated method stub
		return AppRepo.getApplicationByCustID(CustId);
	}
	
	@Override
	public void deleteApplicationService(Long custId) {
		try {
			AppRepo.deleteApplication(custId);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatusService(Long custId) {
		try {
			System.out.println("Service called " + custId);
			AppRepo.updateStatus(custId);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateApplicationService(Long custId) {
		try {
			System.out.println("Update Application Service called ");
			AppRepo.updateApplication(custId);
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public Long getApplicationNoService(Customer customer) {
		
		return AppRepo.getApplicationNo(customer);
	}

}
