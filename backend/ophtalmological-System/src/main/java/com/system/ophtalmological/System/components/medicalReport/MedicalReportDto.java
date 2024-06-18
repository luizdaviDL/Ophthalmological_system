package com.system.ophtalmological.System.components.medicalReport;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.components.report.ReportDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalReportDto {
	private Long id; 
	private ReportDto report;
	private PatientDto patient;
	private ClerkDto clerck;
	
	public MedicalReportDto(Long id, ReportDto report, PatientDto patient, ClerkDto clerck) {
		super();
		this.id = id;
		this.report = report;
		this.patient = patient;
		this.clerck = clerck;
	}
	
	public MedicalReportDto() {
		super();
	}
	
	
}
