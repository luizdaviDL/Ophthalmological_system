package com.system.ophtalmological.System.components.diary;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.entity.Diary;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DiaryDto {
	private Long id;
	private PatientDto patient;
	private AppointmentDto appointment; 
	private ClerkDto doctor;
	private Date date;
	private LocalTime time;
	private boolean status;
	
	public DiaryDto() {
		super();
	}
	public DiaryDto(Long id, PatientDto patient, AppointmentDto appointment, ClerkDto doctor, Date date,
			LocalTime time, boolean status) {
		super();
		this.id = id;
		this.patient = patient;
		this.appointment = appointment;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	
	public DiaryDto(Long id, PatientDto patient, AppointmentDto appointment, ClerkDto doctor, Date date,
			LocalTime time) {
		super();
		this.id = id;
		this.patient = patient;
		this.appointment = appointment;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
	
	}
	
	
	
}
