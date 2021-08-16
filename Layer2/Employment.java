package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the EMPLOYMENT database table.
 * 
 */
@Entity
@Table(name="EMPLOYMENT")
@NamedQuery(name="Employment.findAll", query="SELECT e FROM Employment e")
public class Employment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EID")
	private Long eid;

	@Column(name="EMPLOYER_NAME")
	private String employerName;

	@Column(name="INCOME_FROM_OTHER_SOURCES")
	private Double incomeFromOtherSources;

	@Column(name="INCOME_PAT")
	private Double incomePat;

	@Column(name="NET_MONTHLY_INCOME")
	private Double netMonthlyIncome;

	@Column(name="ORGANIZATION_TYPE")
	private String organizationType;

	@Column(name="RETIREMENT_AGE")
	private String retirementAge;

	@Column(name="TYPE_OF_EMPLOYEMENT")
	private String typeOfEmployement;

	@Column(name="WORK_EXPERIENCE")
	private Integer workExperience;

	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Employment() {
	}

	public Long getEid() {
		return this.eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	public String getEmployerName() {
		return this.employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public Double getIncomeFromOtherSources() {
		return this.incomeFromOtherSources;
	}

	public void setIncomeFromOtherSources(Double incomeFromOtherSources) {
		this.incomeFromOtherSources = incomeFromOtherSources;
	}

	public Double getIncomePat() {
		return this.incomePat;
	}

	public void setIncomePat(Double incomePat) {
		this.incomePat = incomePat;
	}

	public Double getNetMonthlyIncome() {
		return this.netMonthlyIncome;
	}

	public void setNetMonthlyIncome(Double netMonthlyIncome) {
		this.netMonthlyIncome = netMonthlyIncome;
	}

	public String getOrganizationType() {
		return this.organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}

	public String getRetirementAge() {
		return this.retirementAge;
	}

	public void setRetirementAge(String retirementAge) {
		this.retirementAge = retirementAge;
	}

	public String getTypeOfEmployement() {
		return this.typeOfEmployement;
	}

	public void setTypeOfEmployement(String typeOfEmployement) {
		this.typeOfEmployement = typeOfEmployement;
	}

	public Integer getWorkExperience() {
		return this.workExperience;
	}

	public void setWorkExperience(Integer workExperience) {
		this.workExperience = workExperience;
	}


	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}