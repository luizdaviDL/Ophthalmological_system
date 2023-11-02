package com.system.ophtalmological.System.components.patients;


import com.system.ophtalmological.System.entity.Patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetDatasPatient {
	private Long id;
	private String fullname;// birt,, rg cpd
	private String birthdate;
	private String cpf;
	private String rg;
	
	public GetDatasPatient(Long id, String fullname, String birthdate, String cpf, String rg) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.birthdate = birthdate;
		this.cpf = cpf;
		this.rg = rg;
	}
	public GetDatasPatient(Patient i) {
		super();
		this.id = i.getId();
		this.fullname = i.getFullname();
		this.birthdate = i.getBirthDate();
		this.cpf = i.getCpf();
		this.rg = i.getRg();
	}
	public GetDatasPatient() {
		super();
	}

	
	
	
}
