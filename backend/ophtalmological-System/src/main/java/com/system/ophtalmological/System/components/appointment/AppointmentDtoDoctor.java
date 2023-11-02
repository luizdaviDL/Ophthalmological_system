package com.system.ophtalmological.System.components.appointment;

import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDtoDoctor {
	private Long id;
	private String name;
	private DoctorDto doctors;
	public AppointmentDtoDoctor() {
		super();
	}
	public AppointmentDtoDoctor(Long id, String name, DoctorDto doctors) {
		super();
		this.id = id;
		this.name = name;
		this.doctors = doctors;
	}
	
	
}
