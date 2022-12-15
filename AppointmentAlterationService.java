package io.javapractice.appointmentAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AppointmentAlterationService {

	private List<AppointmentAlteration> appointments = new ArrayList(Arrays.asList(

			new AppointmentAlteration("231", "Dr.Peter", "Rob Marley", 23, "Monday", "16:00"),
			new AppointmentAlteration("232", "Dr. Emma", " Mik Jackk", 55, "Tuesday", "11:30"),
			new AppointmentAlteration("234", "Dr. Ron", " Tinkle", 32, "Wednesday", "15:45")

	));

	HashMap<String, String> cancelledAppointments = new HashMap<String, String>();
	HashMap<String, String> modifiedAppointments = new HashMap<String, String>();

	public void setCancelledAppointments(String id, String reason) {
		cancelledAppointments.put(id, reason);
	}

	public void setModifiedAppointments(String id, String reason) {
		modifiedAppointments.put(id, reason);
	}

	public void updateAppointment(String id, AppointmentAlteration appointment) {
		for (int i = 0; i < appointments.size(); i++) {
			AppointmentAlteration a = appointments.get(i);
			if (a.getAppointmentId().equals(id)) {
				// if(docavailable)
				appointments.set(i, appointment);
				return;
			}
		}
	}

	public void deleteAppointment(String id) {

		appointments.removeIf(a -> a.getAppointmentId().equals(a));
	}

}
