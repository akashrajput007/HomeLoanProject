package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Collateral;

@Repository
public class CollateralRepositoryImpl extends BaseRepository implements CollateralRepository {

	@Transactional
	public void insertCollateral(Collateral Ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		entityManager.persist(Ref);
		System.out.println("Collateral details inserted..." + Ref);
	}

	@Transactional
	public List<Collateral> getAllCollateral() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from Collateral");
		List<Collateral> CollateralList = query.getResultList();
		return CollateralList;

	}

	@Transactional
	public Collateral getCollateralByCustID(Long CustId) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" select c from Collateral c where c.customer.custId = :vCustID ");
		query.setParameter("vCustID", CustId);
		List<Collateral> CollateralList = query.getResultList();
		return CollateralList.get(0);
	}

}
