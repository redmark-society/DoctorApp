package io.javapractice.appointmentAlteration;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentAlterationController {

	@Autowired
	private AppointmentAlterationService appointmnetAlterationService;

	@Autowired
	private AppointmentAlteration appointmentAlteration;

	@RequestMapping(method = RequestMethod.DELETE, value = "/appointments/{id}")
	public String deleteAppointment(@RequestBody String description, @PathVariable String id) {
		appointmentAlteration.setDescription(description);
		appointmnetAlterationService.setCancelledAppointments(id, description);
		appointmnetAlterationService.deleteAppointment(id);
		return "Appointment Cancelled";

	}

	/*
	 * @RequestMapping(method = RequestMethod.PUT, value = "/appointments/{id}")
	 * public ResponseEntity<AppointmentAlteration> updateAppointment( @RequestBody
	 * AppointmentAlteration appointment,
	 * 
	 * @PathVariable String id) throws JSONException {
	 * appointmentAlteration.setDescription(appointment.getDescription());
	 * appointmnetAlterationService.setModifiedAppointments(id,
	 * appointment.getDescription());
	 * appointmnetAlterationService.updateAppointment(id, appointment);
	 * 
	 * JSONObject entity = new JSONObject(); entity.put("Appointment Status",
	 * "Successfully Booked"); entity.put("id", id); entity.put("Patient Name",
	 * appointment.getPatient()); entity.put("Patient Age",
	 * appointment.getPatientAge()); entity.put("Doctor", appointment.getDoctor());
	 * entity.put("Modified Day", appointment.getDay()); entity.put("Modified Time",
	 * appointment.getTime());
	 * 
	 * return entity;
	 * 
	 * return appointment;
	 * 
	 * }
	 */

	@RequestMapping(method = RequestMethod.PUT, value = "/appointments/{id}")
	public ResponseEntity<AppointmentAlteration> updateAppointment(@RequestBody AppointmentAlteration appointment,
			@PathVariable String id) {
		appointmentAlteration.setDescription(appointment.getDescription());
		appointmnetAlterationService.setModifiedAppointments(id, appointment.getDescription());
		appointmnetAlterationService.updateAppointment(id, appointment);

		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Appointment Status:", "Succesfully updated");

		return ResponseEntity.ok().headers(responseHeaders).body(appointment);

	}

}
