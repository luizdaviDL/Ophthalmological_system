package com.system.ophtalmological.System.components.patients;

import com.system.ophtalmological.System.entity.Patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientDto {
	private Long id;
	private String fullname;
	private String rg;
	private String email;
	
	public PatientDto(Patient savePa) {
		super();
		this.id = savePa.getId();
		this.fullname = savePa.getFullname();
		this.rg = savePa.getRg();
		this.email = savePa.getEmail();
	}
	
}
