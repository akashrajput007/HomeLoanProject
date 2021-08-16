package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.ApplicationNotFoundException;

@Repository
public class ApplicationRepositoryImpl extends BaseRepository implements ApplicationRepository {

	@Transactional
	public void insertApplication(Application Ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		entityManager.persist(Ref);
		System.out.println("Application inserted..." + Ref);
	
	}

	@Transactional
	public List<Application> selectAllApplication() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from Application");
		List<Application> application = query.getResultList();
		return application;
	
	}

	@Transactional
	public Application getApplicationByCustID(Long custId) {
		// TODO Auto-generated method stub
		Query q = super.getEntityManager().createQuery("select a from Application a where a.customer.custId = :vCustID");
		q.setParameter("vCustID", custId);
		System.out.println("cust id = " + custId);
		List<Application> appList = q.getResultList();
		return appList.get(0);
	}
	
	
	public Long getApplicationNo(Customer customer) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Application a where a.customer.custId =:vCustID");
		query.setParameter("vCustID", customer.getCustId());
		List<Application> appList = query.getResultList();
		Long applicationNo = appList.get(0).getApplicationNo();
		return applicationNo;
	}
	
	
	
	@Transactional
	public void deleteApplication(Long custId) throws ApplicationNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Application a where a.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Application> applicationList =  query.getResultList();
		Application tempApplication = applicationList.get(0);
		
		if(tempApplication != null)
		entityManager.remove(tempApplication);
		else
			throw new ApplicationNotFoundException("Application Not found with custId" + custId);
		System.out.println("Application removed ");
	}

	@Transactional
	public void updateStatus(Long custId) throws ApplicationNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("UPDATE Application a SET a.status = :vstatus where a.customer.custId =:vcustId");
		query.setParameter("vstatus", "REJECTED");
		query.setParameter("vcustId", custId);
		int rows = query.executeUpdate();
		System.out.println("Rows Updated" + rows);
     }

	@Transactional
	public void updateApplication(Long custId) throws ApplicationNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("UPDATE Application a SET a.status = :vstatus where a.customer.custId =:vcustId");
		query.setParameter("vstatus", "APPROVED");
		query.setParameter("vcustId", custId);
		int rows = query.executeUpdate();
		System.out.println("Rows Updated" + rows);
	
	}

}
