package com.system.ophtalmological.System.components.appointment;

import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentDto {
	private Long id;
	private String name;
	
	public AppointmentDto(Appointment save) {
		super();
		this.id = save.getId();
		this.name = save.getName();
	}

	public AppointmentDto(List<Appointment> get) {
		// TODO Auto-generated constructor stub
	}

	public AppointmentDto(AppointmentDto i) {
		// TODO Auto-generated constructor stub
	}

	

	
	

	
	
}
