package com.system.ophtalmological.System.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="clerk")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Clerk extends Person{
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	@OneToMany
	private List<Appointment> especiality;
	
	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
	}
	/*
	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
		this.department = department;
		
	}*/
	
	/*
	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department,List<Appointment> especiality) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
		this.department = department;
		this.especiality.addAll(especiality);
	}*/
	
	public Clerk() {
		super();
	}

	
	public void addEspecialitys(List<Appointment> data) {
		this.especiality = new ArrayList<>();
		this.especiality.addAll(data);
	}
	
}
