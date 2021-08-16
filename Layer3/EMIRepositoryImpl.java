package com.example.demo.Layer3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Emi;
import com.example.demo.Layer2.Loan;

@Repository
public class EMIRepositoryImpl extends BaseRepository implements EMIRepository {

	@Transactional
	public void insertEMI(Long custId) {
		EntityManager entityManager = getEntityManager();
		Customer cust = entityManager.find(Customer.class, custId);
		Query query = entityManager.createQuery("select a from Application a where a.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Application> applicationList =  query.getResultList();
		Application tempApplication = applicationList.get(0);
        Long applicationNo = tempApplication.getApplicationNo();
        System.out.println("Application Number is " + applicationNo);
        
        Query query2 = entityManager.createQuery("select l from Loan l where l.application.applicationNo=:vappNo");
        query2.setParameter("vappNo", applicationNo);
        List<Loan> loanList =  query2.getResultList();
		Loan temploan = loanList.get(0);
		System.out.println("Loan fetched successfully");
		Query query3 = entityManager.createQuery("select e from Emi e where e.customer.custId=:vcustId");
		query3.setParameter("vcustId", custId);
		ArrayList<Emi> emiList = (ArrayList<Emi>)query3.getResultList();
		
		Emi emi = new Emi();
		emi.setCustomer(cust);
		emi.setLoan(temploan);
		emi.setStatus("PENDING");
		LocalDate date1 = null;
		LocalDate date2 = null;
		int len = emiList.size();
		if( len == 0) {
			 date1 = LocalDate.now();
			 System.out.println(date1.getMonthValue());
			 date2 = date1.plusMonths(1);
			 System.out.println(date2.getMonthValue());
			 
		}
		else {
//			Query query = entityManager.createQuery("UPDATE Application a SET a.status = :vstatus where a.customer.custId =:vcustId");
			Emi emi1 = emiList.get(len - 1);
			Long emiId = emi1.getEmiId();
		    System.out.println("emiId is" + emiId);
			date1 = emi1.getEmiDueDate();
			Query query4 = entityManager.createQuery("UPDATE Emi e SET e.status=:vstatus WHERE e.emiId=:vemiId and e.customer.custId=:vcustId");
			query4.setParameter("vstatus", "PAID");
			query4.setParameter("vemiId", emiId);
			query4.setParameter("vcustId", custId);
			int rowsUpdated = query4.executeUpdate();
			System.out.println("rows updated " + rowsUpdated);
			System.out.println("Status Updated");
			System.out.println(date1.getMonthValue());
			date2 = date1.plusMonths(1);
			System.out.println(date2.getMonthValue());
		}
		emi.setEmiDueDate(date2);
		entityManager.persist(emi);
		System.out.println("EMI Added Successfully ");
		
	}

	@Transactional
	public List<Emi> selectEMI(Long custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Emi e where e.customer.custId=:vcustId");
		query.setParameter("vcustId", custId);
		List<Emi> emiList =  query.getResultList();
		return emiList;
	}
 
}