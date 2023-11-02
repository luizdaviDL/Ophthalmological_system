package com.system.ophtalmological.System.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name="patient")
@Entity
public class Patient extends Person{
	
	private LocalDate redisterDate = LocalDate.now();
	@OneToMany
	private List<MediclaReport> medicalHistory = new ArrayList<>();
	@OneToMany
	private List<Diary> diary= new ArrayList<>();
	
	public Patient() {
		super();
	}
	public Patient(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, LocalDate redisterDate, List<MediclaReport> medicalHistory,
			List<Diary> diary) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
		this.redisterDate = redisterDate;
		this.medicalHistory = medicalHistory;
		this.diary = diary;
	}


}
