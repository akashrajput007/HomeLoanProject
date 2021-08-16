package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Layer2.Property;
import com.example.demo.Layer3.Exceptions.PropertyNotFoundException;


@Repository
public class PropertyRepositoryImpl extends BaseRepository implements PropertyRepository {

	@Transactional
	public void insertProperty(Property property) {
		EntityManager entityManager = getEntityManager();
		entityManager.merge(property);
		System.out.println("Property Stored ...");
	}

	@Transactional
	public Property selectProperty(Long custId) {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Property p where p.customer.custId = :vcustId");
		query.setParameter("vcustId", custId);
		List<Property> propertyListAsPerCustId = query.getResultList();
		return propertyListAsPerCustId.get(0);
	}
	
	@Transactional
	public void deleteProperty(Long custId) throws PropertyNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Property p where p.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Property> propertyList =  query.getResultList();
		Property tempProperty = propertyList.get(0);
		
		if(tempProperty != null)
		entityManager.remove(tempProperty);
		else
			throw new PropertyNotFoundException("Property Not found with custId" + custId);
		System.out.println("Property removed ");
	}
	
	@Transactional
	public List<Property> selectAllProperty() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from Property");
		return query.getResultList();
	}


}
