package org.uhc.ws.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Drug {
	@Id
	@GeneratedValue
	private Long id;
	private String drugName;
	private String company;
	
	public Drug() {
		super();
	}

	public Drug(Long id, String drugName, String company) {
		super();
		this.id = id;
		this.drugName = drugName;
		this.company = company;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", drugName=" + drugName + ", company=" + company + "]";
	}
	
	
	
	

}
