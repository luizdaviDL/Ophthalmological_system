package com.system.ophtalmological.System.components.medicalReport;

import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.entity.Report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class saveMR {
	private Long id;
	private Long idReport; 
	private Long idPatient;
	private Long idDoctor;
	private String document;
	private byte[] documentPdf; 
	
	public saveMR(Long idReport, Long idPatient, Long idDoctor, String document,byte[] pdf) {
		super();
		this.idReport = idReport;
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.document = document;
		this.documentPdf = pdf;
	}
	
	public saveMR(Long idReport) {
		super();
		this.idReport = idReport;
		
	}
	public saveMR() {
		super();
	}
	
	
	
}
