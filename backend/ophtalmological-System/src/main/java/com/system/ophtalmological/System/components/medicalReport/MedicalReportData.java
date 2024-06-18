package com.system.ophtalmological.System.components.medicalReport;

import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.MedicalReport;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.entity.Report;

@Component
public class MedicalReportData {

	public MedicalReport saving(Report report, Patient patient, Clerk clerk, String document,byte[] pdf) {
		System.out.println(patient);
		MedicalReport instance = new MedicalReport(report,patient,clerk,document,pdf);
		//instance.setWrittenDocument(document);
		return instance;
	}

	public MedicalReport saving(Report report, Patient patient, Clerk clerk, String document) {
		System.out.println(patient);
		MedicalReport instance = new MedicalReport(report,patient,clerk,document);
		//instance.setWrittenDocument(document);
		return instance;
	}

	


	

}
