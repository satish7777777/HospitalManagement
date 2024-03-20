package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.DoctorDao;
import com.hospital.daoimp.DoctorDaoImpl;
import com.hospital.entity.Doctor;
import com.hospital.service.DoctorService;

public class DoctorServiceImpl implements DoctorService {
	DoctorDao doctorDao=new DoctorDaoImpl();

	@Override
	public Doctor createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
		return doctorDao.createDoctor(doctor);

	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorDao.getAllDoctors();
	}

	@Override
	public Doctor getDoctor(int doctorid) {
		// TODO Auto-generated method stub
		return doctorDao.getDoctor(doctorid);
	}

	@Override
	public Doctor updateDoctor(int doctorid, Doctor updatedDoctor) {
		// TODO Auto-generated method stub
		return doctorDao.updateDoctor(doctorid,updatedDoctor);
	}

	@Override
	public int deleteDoctor(int doctorid) {
		// TODO Auto-generated method stub
		return doctorDao.deleteDoctor(doctorid);
	}

}
