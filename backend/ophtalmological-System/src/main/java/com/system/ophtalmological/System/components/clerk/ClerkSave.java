package com.system.ophtalmological.System.components.clerk;

import com.system.ophtalmological.System.entity.Department;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClerkSave {
	//private Long id;
	private String fullname;
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;	
	private Department department;
	
	public ClerkSave(//Long id, 
			String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department) {
		super();
		//this.id = id;
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
		this.department = department;
	}
	
}
