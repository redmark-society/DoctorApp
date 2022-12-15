package com.doctorapp.precription.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.doctorapp.patients.Patients;
import com.doctorapp.patients.repo.PatientRepository;

public class DoctorPrescriptionService {
	
	@Autowired
	private PatientRepository patientRepository;
	
	
	public String updateMedicalHistory(int patientId, String medicines) {
		Patients currentPatient = patientRepository.findByPatientId(patientId);
		currentPatient.addMedicalHistory(medicines);
		patientRepository.save(currentPatient);
		return "Medical Record of the patient succesfully updated";
		
	}

}
