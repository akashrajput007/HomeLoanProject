package com.example.demo.Layer3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Layer2.Customer;

@Repository
public interface CustomerDetails extends JpaRepository<Customer, Long> {

	@Query(value="SELECT * FROM CUSTOMER WHERE EMAIL_ID =:EMAIL_ID",nativeQuery=true)
	Customer findByEmail(@Param("EMAIL_ID") String email);
	
	@Query(value="SELECT * FROM CUSTOMER WHERE CUST_ID = :CUST_ID",nativeQuery=true)
	Customer updatePassword(@Param("CUST_ID") Long cust_id);
	

}
