package com.hospital.dao;

import java.util.List;

import com.hospital.entity.Doctor;

public interface DoctorDao {

	Doctor createDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getDoctor(int doctorid);
	Doctor updateDoctor(int doctorid,Doctor updatedDoctor);
	int deleteDoctor(int doctorid);

}
