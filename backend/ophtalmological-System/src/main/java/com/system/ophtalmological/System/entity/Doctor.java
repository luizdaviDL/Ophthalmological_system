package com.system.ophtalmological.System.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="doctor")
@Entity
public class Doctor extends Clerk{
	
	@OneToMany
	private List<Appointment> especiality;
	public Doctor(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department, List<Appointment> especiality) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate, department);
		this.especiality = new ArrayList<>();
		this.especiality.addAll(especiality);
		//setEspeciality(especiality);
	}
	/*
	public void setEspeciality(List<Appointment> data) {
		this.especiality.addAll(data);
	}*/

	public Doctor() {
		super();
	}

}
