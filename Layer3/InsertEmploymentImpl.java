package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Employment;
import com.example.demo.Layer3.Exceptions.EmploymentNotFoundException;

@Repository
public class InsertEmploymentImpl extends BaseRepository implements EmploymentRepository {

	@Transactional
	public void insertEmployment(Employment Ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		entityManager.persist(Ref);
		System.out.println("Employment details inserted..." + Ref);
		
	}

	@Override
	public List<Employment> getAllEmployment() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from Employment");
		List<Employment> employmentList = query.getResultList();
		return employmentList;
	
	}

	@Transactional
	public void deleteEmployment(Long custId) throws EmploymentNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Employment e where e.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Employment> applicationList =  query.getResultList();
		Employment tempApplication = applicationList.get(0);
		
		if(tempApplication != null)
		entityManager.remove(tempApplication);
		else
			throw new EmploymentNotFoundException("Application Not found with custId" + custId);
		System.out.println("Application removed ");
	}



	

}
