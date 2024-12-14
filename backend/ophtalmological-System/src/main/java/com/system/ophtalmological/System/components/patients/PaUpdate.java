package com.system.ophtalmological.System.components.patients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaUpdate {
	private Long id;
	private String name;
	private String lastName;
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;
	public PaUpdate(Long id, String name, String lastName, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
	}
	
	
}
