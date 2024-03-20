package com.hospital.service;
import java.util.List;

import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;

public interface DoctorService {

	Doctor createDoctor(Doctor doctor);
	List<Doctor> getAllDoctors();
	Doctor getDoctor(int doctorid);
	Doctor updateDoctor(int doctorid,Doctor updatedDoctor);
	int deleteDoctor(int doctorid);

}