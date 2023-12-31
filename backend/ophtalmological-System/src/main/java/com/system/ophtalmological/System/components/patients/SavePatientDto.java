package com.system.ophtalmological.System.components.patients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SavePatientDto {
	private Long id;
	private String fullname;
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;
	public SavePatientDto(Long id, String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
	}
	
		
}
