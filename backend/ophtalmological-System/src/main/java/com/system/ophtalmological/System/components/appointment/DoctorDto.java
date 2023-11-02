package com.system.ophtalmological.System.components.appointment;

import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
	private Long id;
	private String fullname;	
	private List<Appointment> especialty;
	
	public DoctorDto(Long id, String fullname, List<Appointment> especialty) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.especialty = especialty;
	}

	public DoctorDto() {
		super();
	}
	
	
}
