package com.hospital.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.entity.Appointment;


public class HibernateUtil {
	
	private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory()
{

	try {
		return new Configuration().configure("Hospital.cfg.xml")
				.addAnnotatedClass(Patient.class)
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Appointment.class)
				
				.buildSessionFactory();
		
	}catch (Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}

public static SessionFactory getSessionFactory() {
	return sessionFactory;
}

public static Session getSession()
{
  return getSessionFactory().openSession(); //session opened
}
	
}
