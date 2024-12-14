package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.patients.GetDatasPatient;
import com.system.ophtalmological.System.components.patients.PatientData;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.components.patients.SavePatientDto;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.repository.PatientRepository;

@Service
public class PatientService {
	//repository
	@Autowired
	private PatientRepository repository;
	@Autowired
	private PatientData dataClass;
	
	//save
	public PatientDto save(SavePatientDto patient) {
		//variable
		Patient savePa = null;
		PatientDto paDto = null;
		Patient paClass = dataClass.patientData(patient);		
		Optional<Patient> entity = repository.findByCpf(paClass.getCpf());
		if(entity.isEmpty()) {
			 savePa = repository.save(paClass);
			 paDto = new PatientDto(savePa);
			 
		}else if(entity.isPresent()) {
			throw new BusinessExceptio("Cpf already exist");
		}
		
		return paDto;
	}
	
	//update
	public PatientDto updateP(SavePatientDto patient) {
		Patient savePa = null;
		PatientDto paDto = null;
		Patient paClass = dataClass.patientData(patient);
		Patient findId = repository.findById(paClass.getId()).get();
		System.out.print("id:"+findId);
		//System.out.print("id:" + paClass.getId());
		if(findId != null) {
			savePa = repository.save(paClass);
			 paDto = new PatientDto(savePa);	
		}else {
			throw new BusinessExceptio("Usuario não encontrado");
		}
		
		return paDto;
	}
	
	//getDocument
	public GetDatasPatient getDocument(String document) {
		//String getCpf = dataClass.findCpf(doNumber);
		GetDatasPatient datas = dataClass.getDatasPatient(document);
		
		//String paCpf = dataClass.findCpf(document);
		
		return datas;
	}

	//getAll
	public List<GetDatasPatient> allPatients() {
		List<Patient> pat = repository.findAll();
		List<GetDatasPatient> data = dataClass.getAll(pat);
		return data;
	}

	//delete
	public List<GetDatasPatient> delete(Long data) {
		Optional<Patient> delete = repository.findById(data);
		if(delete.isPresent()) {
			//Patient dataCla = dataClass.patientData(data);
			repository.deleteById(data);
			
		}
		else {
			throw new BusinessExceptio("Usuario não encontrado");
		}
		return allPatients();
		
	}

	//getall
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
