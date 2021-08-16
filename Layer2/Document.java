package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the DOCUMENT database table.
 * 
 */
@Entity
@Table(name="DOCUMENT")
@NamedQuery(name="Document.findAll", query="SELECT d FROM Document d")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOC_ID")
	private Long docId;

	@Column(name="AADHAR_CARD")
	private String aadharCard;

	@Column(name="AGREEMENT_TO_SALE")
	private String agreementToSale;

	@Column(name="ITRC")
	private String itrc;

	@Column(name="LOA")
	private String loa;

	@Column(name="NOC")
	private String noc;

	@Column(name="PAN_CARD")
	private String panCard;

	@Column(name="PHOTOGRAPH")
	private String photograph;

	@Column(name="SALARY_SLIP")
	private String salarySlip;

	@Column(name="SIGNATURE")
	private String signature;

	@Column(name="VOTER_ID")
	private String voterId;

	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Document() {
	}

	public Long getDocId() {
		return this.docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getAadharCard() {
		return this.aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getAgreementToSale() {
		return this.agreementToSale;
	}

	public void setAgreementToSale(String agreementToSale) {
		this.agreementToSale = agreementToSale;
	}

	public String getItrc() {
		return this.itrc;
	}

	public void setItrc(String itrc) {
		this.itrc = itrc;
	}

	public String getLoa() {
		return this.loa;
	}

	public void setLoa(String loa) {
		this.loa = loa;
	}

	public String getNoc() {
		return this.noc;
	}

	public void setNoc(String noc) {
		this.noc = noc;
	}

	public String getPanCard() {
		return this.panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPhotograph() {
		return this.photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public String getSalarySlip() {
		return this.salarySlip;
	}

	public void setSalarySlip(String salarySlip) {
		this.salarySlip = salarySlip;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getVoterId() {
		return this.voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}