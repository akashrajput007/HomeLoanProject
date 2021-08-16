package com.example.demo.Layer2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the PROPERTY database table.
 * 
 */
@Entity
@Table(name="PROPERTY")
@NamedQuery(name="Property.findAll", query="SELECT p FROM Property p")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="P_ID")
	private Long pId;

	@Column(name="COST")
	private Double cost;

	@Column(name="PROPERTY_LOCATION")
	private String propertyLocation;

	@Column(name="PROPERTY_NAME")
	private String propertyName;

	//bi-directional one-to-one association to Customer
	@OneToOne
	@JoinColumn(name="CUST_ID")
	private Customer customer;

	public Property() {
	}

	public Long getPId() {
		return this.pId;
	}

	public void setPId(Long pId) {
		this.pId = pId;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getPropertyLocation() {
		return this.propertyLocation;
	}

	public void setPropertyLocation(String propertyLocation) {
		this.propertyLocation = propertyLocation;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}


	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}