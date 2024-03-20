package com.hospital.dao;

import java.util.List;

import com.hospital.entity.Appointment;

public interface AppointmentDao {
	Appointment createAppointment(Appointment appointment);
	List<Appointment> getAllAppointments();
	Appointment getAppointment(int appointmentid);
	Appointment updateAppointment(int appointmentid, Appointment updatedAppointment);
	int deleteAppointment(int appointmentid);
//	Appointment updateAppointment(int appointmentid, Appointment updatedAppointment);

}
