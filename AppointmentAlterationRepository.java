package io.javapractice.appointmentAlteration;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppointmentAlterationRepository extends CrudRepository<AppointmentAlteration, String>{

}
