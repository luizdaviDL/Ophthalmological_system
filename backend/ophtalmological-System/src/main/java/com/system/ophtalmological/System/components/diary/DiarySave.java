package com.system.ophtalmological.System.components.diary;

import java.time.LocalTime;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class DiarySave {
	private Long id;
	private Long patient;
	private Long appointment; 
	private Long doctor;
	//when desserialize data in this format dont show erro
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date date;
	private LocalTime time;
	
	
	public DiarySave() {
		super();
	}


	public DiarySave(Long id, Long patient, Long appointment, Long doctor, Date date, LocalTime time) {
		super();
		this.id = id;
		this.patient = patient;
		this.appointment = appointment;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
	}

	public DiarySave(Long id) {
		super();
		this.id = id;
		
	}
}
