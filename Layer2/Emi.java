package com.example.demo.Layer2;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

/**
 * The persistent class for the EMI database table.
 * 
 */
@Entity
@Table(name="EMI")
@NamedQuery(name="Emi.findAll", query="SELECT e FROM Emi e")
public class Emi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMI_ID")
	private Long emiId;


	@Column(name="EMI_DUE_DATE")
	private LocalDate emiDueDate;

	@Column(name="STATUS")
	private String status;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	//bi-directional many-to-one association to Loan
	@ManyToOne
	@JoinColumn(name="LOAN_ACC_NO")
	private Loan loan;

	public Emi() {
	}

	public Long getEmiId() {
		return this.emiId;
	}

	public void setEmiId(Long emiId) {
		this.emiId = emiId;
	}

	public LocalDate getEmiDueDate() {
		return this.emiDueDate;
	}

	public void setEmiDueDate(LocalDate emiDueDate) {
		this.emiDueDate = emiDueDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public Loan getLoan() {
		return this.loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

}