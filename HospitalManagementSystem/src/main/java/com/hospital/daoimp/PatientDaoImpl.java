package com.hospital.daoimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hospital.dao.PatientDao;
import com.hospital.entity.Patient;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.util.*;

public class PatientDaoImpl implements PatientDao{
	Scanner sc=new Scanner(System.in);

	@Override
	public Patient createPatient(Patient patient) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(patient);
			session.getTransaction().commit();
			return patient;
			
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
	public List<Patient> getAllPatients() {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all Patients data
			Query<Patient> query=session.createQuery("FROM Patient");
			List<Patient> patientList=query.list();
			return patientList;
			
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
	public Patient getPatient(int patient_id) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			
			Patient patient=session.get(Patient.class, patient_id);
				return patient;
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
	public Patient updatePatient(int patient_id, Patient updatedPatient) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			Patient patient=session.get(Patient.class, patient_id);
				session.beginTransaction();
				
				patient.setPatient_id(patient_id);
				patient.setName(updatedPatient.getName());
				patient.setAddress(updatedPatient.getAddress());
				patient.setPhone_no(updatedPatient.getPhone_no());
	
				
				session.saveOrUpdate(patient);
				session.getTransaction().commit();
				return patient;
			
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
	public int deletePatient(int patient_id) {
		// TODO Auto-generated method stub
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Patient patient=session.get(Patient.class, patient_id);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(patient);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(patient);//data will remove from session Cache
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
