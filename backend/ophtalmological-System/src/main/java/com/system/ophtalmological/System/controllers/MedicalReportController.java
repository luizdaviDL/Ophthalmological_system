package com.system.ophtalmological.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.medicalReport.MedicalReportDto;
import com.system.ophtalmological.System.components.medicalReport.saveMR;
import com.system.ophtalmological.System.components.patients.SavePatientDto;
import com.system.ophtalmological.System.services.MedicalReportService;

@RestController
@RequestMapping(value="/reports")
public class MedicalReportController {
	
	@Autowired
	private MedicalReportService service;
	
	@PostMapping
	public ResponseEntity<MedicalReportDto> save(@RequestBody saveMR data) {
		MedicalReportDto savingMr = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(savingMr);			
	}
	
	@PostMapping(value="/update")
	public ResponseEntity<MedicalReportDto> update(@RequestBody saveMR data) {
		MedicalReportDto savingMr = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(savingMr);			
	}
	
	@GetMapping(value="/allreports")
	public ResponseEntity<List<MedicalReportDto>> getAll() {
		List<MedicalReportDto> savingMr = service.getAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(savingMr);			
	}
	
	@GetMapping(value="/patient")
	public ResponseEntity<List<MedicalReportDto>> getByPatient(@RequestBody SavePatientDto data) {
		List<MedicalReportDto> patient = service.getByPatient(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);			
	}
	
	@DeleteMapping(value="/deletedocment")
	public ResponseEntity<Boolean> deletedoc(@RequestBody saveMR data) {
		boolean savingMr = service.deleteDocument(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(savingMr);			
	}
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<Boolean> delete(@RequestBody saveMR data) {
		boolean savingMr = service.delete(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(savingMr);			
	}
	
	
}
