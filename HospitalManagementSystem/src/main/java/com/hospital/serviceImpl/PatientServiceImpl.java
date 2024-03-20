package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.PatientDao;
import com.hospital.daoimp.PatientDaoImpl;
import com.hospital.entity.Patient;
import com.hospital.service.PatientService;

public class PatientServiceImpl implements PatientService {
	
	PatientDao patientDao=new PatientDaoImpl();

	@Override
	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDao.createPatient(patient);
	}

	@Override
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		return patientDao.getAllPatients();
	}

	@Override
	public Patient getPatient(int patient_id) {
		// TODO Auto-generated method stub
		return patientDao.getPatient(patient_id);
	}

	@Override
	public Patient updatePatient(int patient_id, Patient updatedPatient) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient(patient_id, updatedPatient);
	}

	@Override
	public int deletePatient(int patient_id) {
		// TODO Auto-generated method stub
		return patientDao.deletePatient(patient_id);
	}

}
