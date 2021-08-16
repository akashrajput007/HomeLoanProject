package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.AddressNotFoundException;




@Repository
public class AddressRepositoryImpl extends BaseRepository implements AddressRepository {

	@Transactional
	public void insertAddress(Address Ref) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		entityManager.persist(Ref);
		System.out.println("Residential Address inserted..." + Ref);
	}

	@Override
	public List<Address> selectAllAddress() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery(" from Address");
		List<Address> address = query.getResultList();
		return address;
		
	}
	
	
	//this method is not working...we are not able to find row using custid

	@Transactional
	public Address selectAddressByCustID(Long custId) throws AddressNotFoundException  {
		// TODO Auto-generated method stub
		System.out.println("selectAddressByCustID() called....Layer 3");		
		
		Query q = super.getEntityManager().createQuery("select a from Address a where a.customer.custId = :vCustID");
		q.setParameter("vCustID", custId);
		System.out.println("cust id = " + custId);
		List<Address> addList = q.getResultList();
		return addList.get(0);		
	}
	

	@Transactional
	public void deleteAddress(Long custId) throws AddressNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select a from Address a where a.customer.custId =:vcustId");
		query.setParameter("vcustId", custId);
		List<Address> addressList =  query.getResultList();
		Address tempAddress = addressList.get(0);
		
		if(tempAddress != null)
		entityManager.remove(tempAddress);
		else
			throw new AddressNotFoundException("Address Not found with custId" + custId);
		System.out.println("Address removed ");
	}

}
