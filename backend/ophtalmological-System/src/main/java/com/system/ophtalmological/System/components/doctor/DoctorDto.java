package com.system.ophtalmological.System.components.doctor;

import java.util.List;

import com.system.ophtalmological.System.components.appointment.AppointmentDto;

public class DoctorDto {
	private Long id;
	private String fullname;	
	private List<AppointmentDto> especiality;
	
	public DoctorDto() {
		super();
	}

}
