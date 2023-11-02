package com.system.ophtalmological.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.patients.GetDatasPatient;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.components.patients.SavePatientDto;
import com.system.ophtalmological.System.components.patients.SearchByDocumentPatient;
import com.system.ophtalmological.System.services.PatientService;

@RestController
@RequestMapping(value="/patient")
public class PatientController {
	@Autowired
	private  PatientService service;
	//save
	@PostMapping
	public ResponseEntity<PatientDto> save(@RequestBody SavePatientDto patient) {
		//service save
		PatientDto serviceR = service.save(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceR);
	}
	
	//update
	@PutMapping
	public ResponseEntity<PatientDto> update(@RequestBody SavePatientDto patient) {
		PatientDto serviceUp = service.updateP(patient);
		return ResponseEntity.status(HttpStatus.OK).body(serviceUp);
	}
	//get by document(cpf)
	@GetMapping(value="/document")
	public ResponseEntity<GetDatasPatient> getDocument(@RequestBody SearchByDocumentPatient data) {
		GetDatasPatient documentGet = service.getDocument(data.getCpf());
		return ResponseEntity.status(HttpStatus.OK).body(documentGet);
	}
	
	//getall
	@GetMapping(value="/patients")
	public ResponseEntity<List<GetDatasPatient>> allPatients() {
		List<GetDatasPatient> patients = service.allPatients();
		return ResponseEntity.status(HttpStatus.OK).body(patients);
	}
	
	//delete
	@DeleteMapping
	public ResponseEntity<List<GetDatasPatient>> delete(@RequestBody SearchByDocumentPatient data) {
		List<GetDatasPatient> patients = service.delete(data.getId());
		return ResponseEntity.status(HttpStatus.OK).body(patients);
	}
	
}
