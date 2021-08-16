package com.example.demo.Layer3;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Layer2.Loan;


@Repository
public class LoanAccountNoRepositoryImpl extends BaseRepository implements LoanAccountNoRepository {
	
	public LoanAccountNoRepositoryImpl() {
		System.out.println("LoanAccountNoRepositoryImpl() constructed...");
	}
	
	@Transactional
	public List<Loan> getNo(Long  ApplicationNo) {
		
		EntityManager entityManager = getEntityManager();
		Query query = super.getEntityManager().createQuery("select e from Loan e where e.application.id = :vloanNo");
		query.setParameter("vloanNo", ApplicationNo);
		List<Loan> loanAccountNoAsPerApplication = query.getResultList();
		if(loanAccountNoAsPerApplication.isEmpty()==false) {
			return loanAccountNoAsPerApplication;
		}
		else {
			return null;
		}		
	}
}
