package com.system.ophtalmological.System.entity;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="clerk")
public  class Clerk extends Person{
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	

	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
		this.department = department;
	}

	public Clerk() {
		super();
	}

	
}
