package com.hospital;

import static com.hospital.AllOperation.PatientInputs;
import static com.hospital.AllOperation.DoctorInputs;


import com.hospital.service.PatientService;
import com.hospital.service.DoctorService;
import com.hospital.service.AppointmentService;
import com.hospital.serviceImpl.AppointmentServiceImpl;
import com.hospital.serviceImpl.DoctorServiceImpl;
import com.hospital.serviceImpl.PatientServiceImpl;


//import com.student.entity.Student;
import com.hospital.entity.Patient;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import static com.hospital.MainOperation.*;

//import com.hospital.entity.Patient;
import com.hospital.entity.Doctor;
import com.hospital.entity.Appointment;

import com.hospital.exception.ResourceNotFoundException;


public class AllOperation {
	

static PatientService patientService=new PatientServiceImpl();
static DoctorService doctorService=new DoctorServiceImpl();
static AppointmentService appointmentService = new AppointmentServiceImpl();
//static CourseService courseService=new CourseServiceImple();
//static InstructorService instructorService=new InstructorServiceImpl();

static Scanner sc=new Scanner(System.in);

public static Patient PatientInputs() 
{
	sc.nextLine();
	System.out.println("Enter Patients id");
	int patient_id=sc.nextInt();
	
	System.out.println("Enter Name");
	String name=sc.next();

	System.out.println("Enter Address");
	String address=sc.next();
	
	System.out.println("Enter Phone number");
	String phone_no=sc.next();
	
;
	
	return new Patient(patient_id, name, address, phone_no);
}

public static Doctor DoctorInputs() 
{
	sc.nextLine();
	System.out.println("Enter Doctor id");
	int doctorid=sc.nextInt();
	
	System.out.println("Enter Doctor Name");
	String name=sc.next();

	System.out.println("Enter Specialiaztion of Doctor");
	String specialization=sc.next();
	

;
	
	return new Doctor(doctorid, name, specialization);
}

public static Appointment AppointmentInputs() {
	
	sc.nextLine();
	System.out.println("Enter Appointment Id");
	int appointmentid = sc.nextInt();
	
	System.out.println("Enter Docter Id");
	int docterid = sc.nextInt();
	
	System.out.println("Enter patient id");
	int patient_id = sc.nextInt();
	
	System.out.println("Enter Date");
	String date = sc.next();
	
	return new Appointment(appointmentid, docterid, patient_id, date);
}

	public static Void PatientOperations()
	{
		while(true) {
			System.out.println("Press 1.Add Patient Details\nPress 2.Retrieve All Patient Data\n"
					+ "Press 3.Update Patient Data\nPress 4.Delete Patient Data\n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Patient patient=PatientInputs();
				Patient savedEntity=patientService.createPatient(patient);
				System.out.println("Patient Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:

				List<Patient> patients = patientService.getAllPatients();

				// Iterate over the list of patients and print each one
				for (Patient patient1 : patients) {
				    System.out.println("Patient ID: " + patient1.getPatient_id());
				    System.out.println("Name: " + patient1.getName());
				    System.out.println("Address: " + patient1.getAddress());
				    System.out.println("Phone Number: " + patient1.getPhone_no());
				    System.out.println(); // Add an empty line for better readability
				}

				break;
				
			case 3:sc.nextLine();
			System.out.println("Enter Patient Id to update the infromation");
		       int pId=sc.nextInt();
		       Patient s=patientService.getPatient(pId);
	           if(s!=null) {
		       Patient pat=updatedPatientData();
		     //service
		       Patient updatedInfo=patientService.updatePatient(pId, pat);
		       System.out.println("Patient Data has been updated Successfully"+ updatedInfo);
		       }
		       
		       else
		       {
		    	   throw new ResourceNotFoundException("Patient Id not found");
		       }

		
		       
			break;
			
			case 4:
				System.out.println("Enter Patient Id to delete the infromation");
			       int id=sc.nextInt();
			       int message=patientService.deletePatient(id);
			       System.out.println(message);
				break;
			case 5:mainOps();
			}
			
		}
		}
	

	public static Void DoctorOperations()
	{
		while(true) {
			System.out.println("Press 1.Add Doctor Details\nPress 2.Retrieve All Doctor Data\n"
					+ "Press 3.Update Doctor Data\nPress 4.Delete Doctor Data\n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Doctor doctor=DoctorInputs();
				Doctor savedEntity=doctorService.createDoctor(doctor);
				System.out.println("Patient Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:

				List<Doctor> doctors = doctorService.getAllDoctors();

				// Iterate over the list of patients and print each one
				for (Doctor doctor1 : doctors) {
				    System.out.println("Patient ID: " + doctor1.getDoctorid());
				    System.out.println("Name: " + doctor1.getName());
				    System.out.println("Address: " + doctor1.getSpcialization());
				    System.out.println(); // Add an empty line for better readability
				}

				break;
				
			case 3:
			
			sc.nextLine();
			System.out.println("Enter Patient Id to update the infromation");
		       int pId=sc.nextInt();
		       Doctor s=doctorService.getDoctor(pId);
	           if(s!=null) {
	           Doctor pat=updatedDoctortData();
		     //service
	           Doctor updatedInfo=doctorService.updateDoctor(pId, pat);
		       System.out.println("Patient Data has been updated Successfully"+ updatedInfo);
		       }
		       
		       else
		       {
		    	   throw new ResourceNotFoundException("Patient Id not found");
		       }

		
		       
			break;
			
			case 4:
				System.out.println("Enter Patient Id to delete the infromation");
			       int id=sc.nextInt();
			       int message=doctorService.deleteDoctor(id);
			       System.out.println(message);
				break;
			case 5:mainOps();
			}
			
		}
		}
	
	
	public static Void AppointmentOperations()
	{
		while(true) {
			System.out.println("Press 1.Book Appointment\nPress 2.Retrieve All Appointments\n"
					+ "Press 3.Update Appointments Data\nPress 4.Delete Appointments Data\n"
					+ "Press 5.To getback to the main menu");
			int input=sc.nextInt();	
			
			switch(input) {
			case 1:
				Appointment appointment=AppointmentInputs();
				Appointment savedEntity=appointmentService.createAppointment(appointment);
				System.out.println("Appointment Data has been saved successfully"+ savedEntity);
				break;
			
			case 2:

				List<Appointment> appointments = appointmentService.getAllAppointment();

				// Iterate over the list of patients and print each one
				for (Appointment appointment1 : appointments) {
				    System.out.println("Appointment ID: " + appointment1.getAppointmentid());
				    System.out.println("Patient ID: " + appointment1.getPatient_id());
				    System.out.println("Docter ID: " + appointment1.getDoctorid());
				    System.out.println("Date of Appointment" + appointment1.getDate()); // Add an empty line for better readability
				}

				break;
				
			case 3:
				sc.nextLine();
				System.out.println("Enter Appoitment Id to update the infromation");
			       int aptId=sc.nextInt();
			       Appointment s=appointmentService.getAppointment(aptId);
		           if(s!=null) {
		        	Appointment apt=updatedAppointmentData();
			     //service
		        	Appointment updatedInfo=appointmentService.updateAppointment(aptId, apt);
			       System.out.println("Appointment Data has been updated Successfully"+ updatedInfo);
			       }
			       
			       else
			       {
			    	   throw new ResourceNotFoundException("Appointment Id not found");
			       }
		           break;

			
			case 4:
				System.out.println("Enter Patient Id to delete the infromation");
			       int id=sc.nextInt();
			       int message=appointmentService.deleteAppointment(id);
			       System.out.println(message);
				break;
			case 5:mainOps();
			}
			
		}
		}
	
	private static Appointment updatedAppointmentData() {
		// TODO Auto-generated method stub
		
		System.out.println("Enter Appointment id");
		int appointmentid=sc.nextInt();
		
		System.out.println("Enter patient_id");
		int patient_id=sc.nextInt();

		System.out.println("Enter docter_id");
		int doctorid=sc.nextInt();
		
		System.out.println("Enter date");
		String date=sc.next();
		return new Appointment(appointmentid, patient_id, doctorid, date);
	}

	private static Doctor updatedDoctortData() {
		// TODO Auto-generated method stub
//		sc.nextLine();
//		sc.nextInt();
		System.out.println("Enter Doctor id");
		int doctorid=sc.nextInt();
		
		System.out.println("Enter Doctor Name");
		String name=sc.next();

		System.out.println("Enter specialization of Doctor");
		String specialization=sc.next();
		
		return new Doctor(doctorid,name, specialization);
	}
		
	
	private static Patient updatedPatientData() {
		// TODO Auto-generated method stub
//		sc.nextLine();
//		sc.nextInt();
		System.out.println("Enter patient id");
		int patient_id=sc.nextInt();
		
		System.out.println("Enter Name");
		String name=sc.next();

		System.out.println("Enter address Name");
		String address=sc.next();
		
		System.out.println("Enter phone nu");
		String phone_no=sc.next();
		
	
		return new Patient(patient_id,name, address, phone_no);
	}
		
		
}

