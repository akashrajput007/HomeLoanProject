package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Loan;

@Repository
public class LoanInsertRepositoryImpl extends BaseRepository implements LoanInsertRepository {

	@Transactional
	public void insertLoan(Long custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Application a where a.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Application> appList = query.getResultList();
		Application app = appList.get(0);
		Double expectedAmount = app.getExpectedAmount();
		System.out.println("Expected Amount" + expectedAmount);
		Integer tenure = app.getTenure();
		Integer totalMonths = tenure*12;
		System.out.println("Tenure is " + tenure);
//		EMI = P*R*{((1+R)^n)/((1+R)^n-1)}
		Double calc1 = Math.pow(1.01, totalMonths);
		Double calc2 = Math.pow(1.01, totalMonths) - 1;
		Double calc = (Double) calc1/calc2;
		System.out.println("Calculate calc" + calc);
		Double EmiAmount = expectedAmount*(0.01)*calc;
		System.out.println("Emi Amount is " + EmiAmount);
		
		Double amountWithInterest = EmiAmount*totalMonths;
		Loan loan = new Loan();
		loan.setAmountPaid(0.0);
		loan.setApprovedAmount(expectedAmount);
		loan.setBalance(expectedAmount);
		loan.setApplication(app);
		loan.setEmiAmount(EmiAmount);
		loan.setAmountWithInterest(amountWithInterest);
		entityManager.persist(loan);
		System.out.println("Loan Details Inserted");
	}
	@Transactional
	public Loan selectLoan(Long custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Application a where a.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Application> appList = query.getResultList();
		Application app = appList.get(0);
		Long appNo = app.getApplicationNo();

		Query query2 = entityManager.createQuery("select l from Loan l where l.application.applicationNo=:vappNo");
        query2.setParameter("vappNo", appNo);
        List<Loan> loanList =  query2.getResultList();
		Loan loan = loanList.get(0);
		System.out.println("Loan fetched successfully");
		return loan;
	}

}