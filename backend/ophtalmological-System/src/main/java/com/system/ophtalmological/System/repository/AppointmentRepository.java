package com.system.ophtalmological.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Appointment;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

	Optional<Appointment> findByname(String name);

	Appointment save(Appointment clas);

	Optional<Appointment> getByname(String name);

		
}
