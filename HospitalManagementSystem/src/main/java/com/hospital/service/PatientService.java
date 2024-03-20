package com.hospital.service;


import com.hospital.entity.Patient;

import java.util.List;

public interface PatientService {
	
	Patient createPatient(Patient patient);
	List<Patient> getAllPatients();
	Patient getPatient(int patient_id);
	Patient updatePatient(int patient_id , Patient updatedPatient);
	int deletePatient(int patient_id);
		
}
	
