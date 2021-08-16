package com.example.demo.Layer3;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer3.Exceptions.CustomerNotFoundException;


@Repository
public  class CustomerRepositoryImpl extends BaseRepository implements CustomerRepository  {

	@Transactional
	public Customer insertCustomer(Customer cust) {
		EntityManager entityManager = getEntityManager() ;
//	    Employment e = new Employment();
//		e.setCustomer(cust);
		//entityManager.merge(cust);
		Customer o = entityManager.merge(cust);
		System.out.println(o);
		System.out.println("Customer Details inserted " + cust );
		return o;
	}

	@Transactional
	public Customer selectCustomer(Long custId) {
		EntityManager entityManager = getEntityManager() ;
		Customer cust = entityManager.find(Customer.class, custId);
//		if(cust != null) {
//			return cust;
//		}
		return cust;
	}

	@Transactional
	public List<Customer> selectAllCustomer() {
		EntityManager entityManager = getEntityManager() ;
		Query query = entityManager.createQuery(" from Customer");
		List<Customer> custList = query.getResultList();
		return custList;
	}
	
	@Transactional
	public void deleteCustomer(Long custId) throws CustomerNotFoundException {
		EntityManager entityManager = getEntityManager();
		Customer tempCustomer = entityManager.find(Customer.class, custId); 
		entityManager.remove(tempCustomer);
		
		
		if(tempCustomer == null) 
			throw new CustomerNotFoundException("Customer Not found with custId" + custId);
		System.out.println("Customer removed ");
	}
	
	@Transactional
	public Customer selectCustomerByEmail(String emailId) throws CustomerNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select c from Customer c where c.emailId=:vemailId");
		query.setParameter("vemailId", emailId);
		List<Customer> customerList = query.getResultList();
		Customer customer = customerList.get(0);
		if(customer != null) {
			return customer;
		}else {
			throw new CustomerNotFoundException("Customer not found with Email Id " + emailId);
		}
		
	}
}
