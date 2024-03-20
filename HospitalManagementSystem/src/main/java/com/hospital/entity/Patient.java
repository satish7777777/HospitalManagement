package com.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
	
	@Id
	@Column(name="Patient_id",length=50)
	int patient_id;
	
	@Column(name="Name",length=50)
	String name;
	
	@Column(name="Address",length=50)
	String address;
	
	@Column(name="Phone_no",length=50)
	String phone_no;
	
	public Patient(int patient_id, String name, String address, String phone_no) {
		super();
		this.patient_id = patient_id;
		this.name = name;
		this.address = address;
		this.phone_no = phone_no;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	
	
	

}
