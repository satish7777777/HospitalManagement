package com.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
//	@Column(name="Doctor_Id",length=50)
	int doctorid;
	
//	@Column(name="Doctor_Name",length=50)
	String name;
	
//	@Column(name="Specialization",length=50)
	String specialization;
	
	public Doctor(int doctorid, String name, String spcialization) {
		super();
		this.doctorid = doctorid;
		this.name = name;
		this.specialization = spcialization;
	}
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpcialization() {
		return specialization;
	}
	public void setSpcialization(String specialization) {
		this.specialization = specialization;
	}
	
	

}
