package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the APPLICATION database table.
 * 
 */
@Entity
@Table(name="APPLICATION")
@NamedQuery(name="Application.findAll", query="SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="APPLICATION_NO")
	private Long applicationNo;

	@Column(name="COMMENTS")
	private String comments;

	@Column(name="STATUS")
	private String status;

	@Column(name="TENURE")
	private Integer tenure;

	@Column(name="EXPECTED_AMOUNT")
	private Double expectedAmount;
	
	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	//bi-directional one-to-one association to Loan
	@OneToOne(mappedBy="application")
	private Loan loan;

	public Application() {
	}

	public Long getApplicationNo() {
		return this.applicationNo;
	}

	public void setApplicationNo(Long applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTenure() {
		return this.tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}
	
	public Double getExpectedAmount() {
		return expectedAmount;
	}

	public void setExpectedAmount(Double expectedAmount) {
		this.expectedAmount = expectedAmount;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonIgnore
	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}