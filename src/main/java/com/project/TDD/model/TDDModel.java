package com.project.TDD.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TDDModel {
	
	

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String company;
	
	
	public TDDModel() {
		
	}
	public TDDModel(String name, String company) {
		
		this.name = name;
		this.company = company;
	}
	public TDDModel(long id, String name, String company) {
	
		this.id = id;
		this.name = name;
		this.company = company;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

}
