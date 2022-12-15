package com.doctorapp.precription.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.doctorapp.precription.service.DoctorPrescriptionService;



public class DoctorPrescriptionController {
	
	@Autowired
	private DoctorPrescriptionService doctorPrescriptionService;
	
	@RequestMapping(method = RequestMethod.POST, value = "doctors/checkedPatients/{patientId}")
	public String addMedicines( @PathVariable int patientId, @RequestBody String medicinesAndTests) {
		doctorPrescriptionService.updateMedicalHistory(patientId, medicinesAndTests);
		return "Currently prescribed medicines added";

	}

}
