package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the COLLATERAL database table.
 * 
 */
@Entity
@Table(name="COLLATERAL")
@NamedQuery(name="Collateral.findAll", query="SELECT c FROM Collateral c")
public class Collateral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COL_ID")
	private Long colId;

	@Column(name="COLLATERAL_TYPE")
	private String collateralType;

	@Column(name="NETWORTH")
	private Double networth;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Collateral() {
	}

	public Long getColId() {
		return this.colId;
	}

	public void setColId(Long colId) {
		this.colId = colId;
	}

	public String getCollateralType() {
		return this.collateralType;
	}

	public void setCollateralType(String collateralType) {
		this.collateralType = collateralType;
	}

	public Double getNetworth() {
		return this.networth;
	}

	public void setNetworth(Double networth) {
		this.networth = networth;
	}


	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}