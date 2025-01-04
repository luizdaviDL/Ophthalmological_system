package com.system.ophtalmological.System.components.appointment;

import java.time.LocalTime;
import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto {
	private Long id;
	private String name;
	private String observation;
	private LocalTime timeDuration;
	private List<String> services;
	
	public AppointmentDto(Appointment save) {
		super();
		this.id = save.getId();
		this.name = save.getName();
		this.observation = save.getObservation();
		this.timeDuration = save.getTimeDuration();
		this.services = save.getServices();
	}

	public AppointmentDto(List<Appointment> get) {
		// TODO Auto-generated constructor stub
	}

	public AppointmentDto(AppointmentDto i) {
		// TODO Auto-generated constructor stub
	}

	

	
	

	
	
}
