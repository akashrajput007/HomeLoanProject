package com.example.demo.Layer2;

import java.util.List;

public class getEMI{
	private Customer customer;
	private Loan loan;
	private Application application;
	private List<Emi> emiList;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public List<Emi> getEmiList() {
		return emiList;
	}
	public void setEmiList(List<Emi> emiList) {
		this.emiList = emiList;
	}
	
}