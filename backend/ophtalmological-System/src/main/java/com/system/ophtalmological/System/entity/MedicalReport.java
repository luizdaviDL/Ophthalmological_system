package com.system.ophtalmological.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="report_medical")
public class MedicalReport {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@ManyToOne
	@JoinColumn(name = "report_id", nullable = false)
	private Report report;
	@ManyToOne
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "doctor_id", nullable = false)
	private Clerk doctor;
	@Lob
	@Column(nullable = true)
	private String writtenDocument;
	@Lob
    @Column(nullable = true)
    private byte[] documentPdf; 
	
	public MedicalReport( Report report, Patient patient, Clerk doctor, String writtenDocument) {
		super();
		this.report = report;
		this.patient = patient;
		this.doctor = doctor;
		this.writtenDocument = writtenDocument;
	}
	
	public MedicalReport( Report report, Patient patient, Clerk doctor, String writtenDocument, byte[] pdf) {
		super();
		this.report = report;
		this.patient = patient;
		this.doctor = doctor;
		this.writtenDocument = writtenDocument;
		this.documentPdf = pdf;
	}

	public MedicalReport() {
		super();
	}

}
