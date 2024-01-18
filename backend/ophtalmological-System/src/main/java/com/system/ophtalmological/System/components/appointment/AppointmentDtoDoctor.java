package com.system.ophtalmological.System.components.appointment;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDtoDoctor {
	private Long id;
	private String name;
	private List<DoctorDto> doctors;
	
	public AppointmentDtoDoctor() {
		super();
	}
	public AppointmentDtoDoctor(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
		
	}
	
	public void doctorToList(DoctorDto data) {
		this.doctors = new ArrayList<>();
		this.doctors.add(data);
	}
}
