package com.system.ophtalmological.System.components.appointment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Doctor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
	private Long id;
	private String fullname;	
	private List<AppointmentDto> especiality;
	
	public DoctorDto() {
		super();
	}

	public DoctorDto(Doctor data, List<AppointmentDto> appointmentList) {
		super();
		this.id = data.getId();
		this.fullname = data.getFullname();
		this.especiality = new ArrayList<>();
		this.especiality.addAll(appointmentList);
	}

}
