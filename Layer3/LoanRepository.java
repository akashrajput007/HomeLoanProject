package com.example.demo.Layer3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
	
	@Query(value = "SELECT BALANCE FROM LOAN WHERE LOAN_ACC_NO =:loanAccountNumber",nativeQuery = true)
	public Long getBalance(@Param("loanAccountNumber") Long loanAccountNumber);

}