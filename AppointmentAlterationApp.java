package io.javapractice.appointmenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "io.javapractice.appointmentAlteration" })
@EnableAutoConfiguration
public class AppointmentAlterationApp  {

	public static void main(String[] args) {

		SpringApplication.run(AppointmentAlterationApp.class, args);

	}

	
}
