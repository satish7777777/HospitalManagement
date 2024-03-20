package com.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Appointment {
	@Id
//	@Column(name="Appointment_id",length=50)
	int appointmentid;
	
	@Column(name="Patient_Id",length=50)
	int patient_id;
	
	@Column(name="Doctor_id",length=50)
	int doctorid;

	@Column(name="Date",length=50)
	String date;
	
	
	public Appointment(int appointmentid, int patient_id, int doctorid, String date) {
		super();
		this.appointmentid = appointmentid;
		this.patient_id = patient_id;
		this.doctorid = doctorid;
		this.date = date;
	}

	
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAppointmentid() {
		return appointmentid;
	}

	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoctorid() {
		return doctorid;
	}

	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	

}
