package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the LOAN database table.
 * 
 */
@Entity
@Table(name="LOAN")
@NamedQuery(name="Loan.findAll", query="SELECT l FROM Loan l")
public class Loan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LOAN_ACC_NO")
	private Long loanAccNo;

	@Column(name="AMOUNT_PAID")
	private Double amountPaid;

	@Column(name="AMOUNT_WITH_INTEREST")
	private Double amountWithInterest;

	@Column(name="APPROVED_AMOUNT")
	private Double approvedAmount;

	@Column(name="BALANCE")
	private Double balance;

	@Column(name="EMI_AMOUNT")
	private Double emiAmount;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Temporal(TemporalType.DATE)
	@Column(name="START_DATE")
	private Date startDate;

	//bi-directional many-to-one association to Emi
	@OneToMany(mappedBy="loan", fetch=FetchType.EAGER)
	private List<Emi> emis;

	//bi-directional one-to-one association to Application
	@OneToOne
	@JoinColumn(name="APPLICATION_NO")
	private Application application;

	public Loan() {
	}

	public Long getLoanAccNo() {
		return this.loanAccNo;
	}

	public void setLoanAccNo(Long loanAccNo) {
		this.loanAccNo = loanAccNo;
	}

	public Double getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(Double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Double getAmountWithInterest() {
		return this.amountWithInterest;
	}

	public void setAmountWithInterest(Double amountWithInterest) {
		this.amountWithInterest = amountWithInterest;
	}

	public Double getApprovedAmount() {
		return this.approvedAmount;
	}

	public void setApprovedAmount(Double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getEmiAmount() {
		return this.emiAmount;
	}

	public void setEmiAmount(Double emiAmount) {
		this.emiAmount = emiAmount;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	
	@JsonIgnore
	public List<Emi> getEmis() {
		return this.emis;
	}

	public void setEmis(List<Emi> emis) {
		this.emis = emis;
	}


	public Emi addEmi(Emi emi) {
		getEmis().add(emi);
		emi.setLoan(this);

		return emi;
	}

	public Emi removeEmi(Emi emi) {
		getEmis().remove(emi);
		emi.setLoan(null);

		return emi;
	}


	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

}