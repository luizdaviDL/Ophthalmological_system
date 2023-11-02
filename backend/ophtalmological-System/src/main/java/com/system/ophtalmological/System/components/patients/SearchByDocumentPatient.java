package com.system.ophtalmological.System.components.patients;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchByDocumentPatient {
	private Long id;
	private String cpf;	
	public SearchByDocumentPatient(String cpf) {
		super();
		this.cpf = cpf;
	}

	public SearchByDocumentPatient() {
		super();
	}	
}
