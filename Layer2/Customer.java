package com.example.demo.Layer2;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@Table(name="CUSTOMER")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID")
	private Long custId;

	@Column(name="AADHAR_NUMBER")
	private String aadharNumber;


	@Column(name="DATE_OF_BIRTH")
	private LocalDate dateOfBirth;

	@Column(name="EMAIL_ID")
	private String emailId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="GENDER")
	private String gender;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="MIDDLE_NAME")
	private String middleName;

	@Column(name="PAN_NUMBER")
	private String panNumber;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;

	@Column(name="TITLE")
	private String title;

	//bi-directional many-to-one association to Collateral
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Collateral> collaterals;

	//bi-directional many-to-one association to Emi
	@OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Emi> emis;

	//bi-directional one-to-one association to Address
	@OneToOne(mappedBy="customer")
	private Address address;

	//bi-directional one-to-one association to Application
	@OneToOne(mappedBy="customer")
	private Application application;

	//bi-directional one-to-one association to Document
	@OneToOne(mappedBy="customer")
	private Document document;

	//bi-directional one-to-one association to Employment
	@OneToOne(mappedBy="customer")
	private Employment employment;

	//bi-directional one-to-one association to Property
	@OneToOne(mappedBy="customer")
	private Property property;

	public Customer() {
	}

	public Long getCustId() {
		return this.custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getAadharNumber() {
		return this.aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPanNumber() {
		return this.panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@JsonIgnore
  	public List<Collateral> getCollaterals() {
		return this.collaterals;
	}

	public void setCollaterals(List<Collateral> collaterals) {
		this.collaterals = collaterals;
	}
	

	@JsonIgnore
	public Collateral addCollateral(Collateral collateral) {
	getCollaterals().add(collateral);
		collateral.setCustomer(this);

		return collateral;
	}

	public Collateral removeCollateral(Collateral collateral) {
		getCollaterals().remove(collateral);
		collateral.setCustomer(null);

		return collateral;
	}


	@JsonIgnore
	public List<Emi> getEmis() {
		return this.emis;
	}

	public void setEmis(List<Emi> emis) {
		this.emis = emis;
	}


	@JsonIgnore
	public Emi addEmi(Emi emi) {
		getEmis().add(emi);
		emi.setCustomer(this);

		return emi;
}


	public Emi removeEmi(Emi emi) {
		getEmis().remove(emi);
		emi.setCustomer(null);

		return emi;
	}


	@JsonIgnore
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}


	@JsonIgnore
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}


	@JsonIgnore
	public Document getDocument() {
		return this.document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}


	@JsonIgnore
	public Employment getEmployment() {
		return this.employment;
	}

	public void setEmployment(Employment employment) {
		this.employment = employment;
	}

	@JsonIgnore
	public Property getProperty() {
		return this.property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
}