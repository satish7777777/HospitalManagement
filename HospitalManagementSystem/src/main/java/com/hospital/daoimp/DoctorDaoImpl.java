package com.hospital.daoimp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.hospital.dao.DoctorDao;
import com.hospital.entity.Doctor;
import com.hospital.entity.Patient;
import com.hospital.exception.ResourceNotFoundException;
import com.hospital.util.*;

public class DoctorDaoImpl implements DoctorDao {
	Scanner sc=new Scanner(System.in);

	@Override
	public Doctor createDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(doctor);
			session.getTransaction().commit();
			return doctor;
			
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
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
            try(Session session=HibernateUtil.getSession()) {
			
			//execute HQL query to retrieve all Patients data
			Query<Doctor> query=session.createQuery("FROM Doctor");
			List<Doctor> doctorList=query.list();
			return doctorList;
			
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
	public Doctor getDoctor(int doctorid) {
		// TODO Auto-generated method stub
            try(Session session=HibernateUtil.getSession()) {
			
            	Doctor doctor=session.get(Doctor.class, doctorid);
				return doctor;
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
	public Doctor updateDoctor(int doctorid ,Doctor updatedDoctor) {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			Doctor doctor=session.get(Doctor.class, doctorid);
				session.beginTransaction();
				
				doctor.setDoctorid(doctorid);
				doctor.setName(updatedDoctor.getName());
				doctor.setSpcialization(updatedDoctor.getSpcialization());
			
	
				
				session.saveOrUpdate(doctor);
				session.getTransaction().commit();
				return doctor;
			
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
	public int deleteDoctor(int doctorid) {
		// TODO Auto-generated method stub
		String message=null;
		try(Session session=HibernateUtil.getSession()) {
			Doctor doctor=session.get(Doctor.class, doctorid);
				session.beginTransaction();
				System.out.println("Are you sure  you want to delete?");
				String status=sc.next();
				if(status.equalsIgnoreCase("yes"))
				{
					session.delete(doctor);//data will be deleted from DB
					session.getTransaction().commit();
					session.evict(doctor);//data will remove from session Cache
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
