package com.system.ophtalmological.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class Clerk extends Person{
	@ManyToOne
	private Department department;

	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
		this.department = department;
	}

	
	

}
