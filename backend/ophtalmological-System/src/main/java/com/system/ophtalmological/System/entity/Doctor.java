package com.system.ophtalmological.System.entity;

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
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToMany
	private List<Appointment> especialty;
	public Doctor(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department, Long id, List<Appointment> especialty) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate, department);
		this.id = id;
		this.especialty = especialty;
	}
	
	
	
	
}
