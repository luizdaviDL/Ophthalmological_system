package com.system.ophtalmological.System.components.clerk;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClerkSave {
	private Long id;
	private String fullname;
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;	
	private Long department;
	private List<Long> especiality;

	public ClerkSave( String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Long department) {
		super();
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
		this.department = department;
	}
	
	public ClerkSave( String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Long department,List<Long> especiality) {
		super();
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
		this.department = department;
		this.especiality = new ArrayList<>();
		this.especiality.addAll(especiality);
	}

	public ClerkSave() {
		super();
	}
	
	
}
