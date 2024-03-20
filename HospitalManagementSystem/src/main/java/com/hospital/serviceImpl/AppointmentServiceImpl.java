package com.hospital.serviceImpl;

import java.util.List;

import com.hospital.dao.AppointmentDao;
import com.hospital.daoimp.AppointmentDaoImpl;
import com.hospital.entity.Appointment;
import com.hospital.entity.Patient;
import com.hospital.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {
	
	AppointmentDao appointmentDao = new AppointmentDaoImpl();
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentDao.createAppointment(appointment);
	}
	
	@Override
	public List<Appointment> getAllAppointment() {
		// TODO Auto-generated method stub
		return appointmentDao.getAllAppointments();
	}
	
	@Override
	public Appointment getAppointment(int appointmentid) {
		// TODO Auto-generated method stub
		return appointmentDao.getAppointment(appointmentid);
	}
	
	@Override
	public Appointment updateAppointment(int appointmentid, Appointment updateAppointment) {
		return appointmentDao.updateAppointment(appointmentid, updateAppointment);
	}
	
	@Override
	public int deleteAppointment(int appointmentid) {
		// TODO Auto-generated method stub
		return appointmentDao.deleteAppointment(appointmentid);
	}

}
