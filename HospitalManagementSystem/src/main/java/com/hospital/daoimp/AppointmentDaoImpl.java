package com.hospital.daoimp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hospital.dao.AppointmentDao;
import com.hospital.entity.Appointment;
import com.hospital.entity.Patient;
import com.hospital.util.HibernateUtil;

public class AppointmentDaoImpl implements AppointmentDao {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public Appointment createAppointment(Appointment appointment) {
		
		try(Session session= HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(appointment);
			session.getTransaction().commit();
			return appointment;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
	
	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all Patients data
			Query<Appointment> query=session.createQuery("FROM Appointment");
			List<Appointment> appointmentList=query.list();
			return appointmentList;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@Override
	public Appointment getAppointment(int appointmentid) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			
			Appointment appointment=session.get(Appointment.class, appointmentid);
				return appointment;
			}
			catch (HibernateException e) {
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
			return null;
	}
	
	@Override
	public Appointment updateAppointment(int appointmentid, Appointment updatedAppointment) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			Appointment appointment=session.get(Appointment.class, appointmentid);
				session.beginTransaction();
				
				appointment.setAppointmentid(appointmentid);
				appointment.setPatient_id(updatedAppointment.getPatient_id());
				appointment.setDoctorid(updatedAppointment.getDoctorid());
				appointment.setDate(updatedAppointment.getDate());
	
				
				session.saveOrUpdate(appointment);
				session.getTransaction().commit();
				return appointment;
			
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	@Override
	public int deleteAppointment(int appointmentid) {
		// TODO Auto-generated method stub
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Appointment appointment=session.get(Appointment.class, appointmentid);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(appointment);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(appointment);//data will remove from session Cache
					message="Data is deleted";
					
				}else
				{
					message="User wants to retain this object!!";
				}
				
		}
		catch (HibernateException e) {
			System.out.println(e);
		}
		catch (Exception e) {
			System.out.println(e);
		}

		return 0;
	}

}
