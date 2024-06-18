package com.system.ophtalmological.System.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="diary")
@Entity
public class Diary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Appointment appointment; //consulta
	@ManyToOne
	private Clerk doctor;
	private Date date;
	private LocalTime time;	
	private boolean status;
	
	public Diary(Patient patient, Appointment appointment, Clerk doctor, Date date, LocalTime time) {
		super();
		this.patient = patient;
		this.appointment = appointment;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.status = true;
	}

	public Diary(Long id, Patient patient, Appointment appointment, Clerk doctor, Date date, LocalTime time,
			boolean status) {
		super();
		this.id = id;
		this.patient = patient;
		this.appointment = appointment;
		this.doctor = doctor;
		this.date = date;
		this.time = time;
		this.status = status;
	}

	public Diary() {
		super();
	}
	
	

	
}
