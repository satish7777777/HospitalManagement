package com.hospital.service;

import java.util.List;

import com.hospital.entity.Appointment;

public interface AppointmentService {
	Appointment createAppointment(Appointment appointment);
	List<Appointment> getAllAppointment();
	Appointment getAppointment(int appointmentid);
	Appointment updateAppointment(int appointment_id, Appointment apt);
	int deleteAppointment(int appointmentid);

}
