package com.system.ophtalmological.System.components.patients;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.repository.PatientRepository;

@Component
public class PatientData {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PatientRepository repository;
	
	//transform saveDto to class
	public Patient patientData(SavePatientDto pa) {
		return mapper.map(pa, Patient.class);				
	}
	
	//findCp
	/*
	public String findCpf(String cpfN) {	
		String cpf = "";
		Object cpfFind = repository.findByCpf(cpfN);
		
		if(cpfFind!=null) {
			cpf = (String) cpfFind;
		}else {
			cpf = null;
		}		
		return cpf;
	}*/
	
	//getDocument dattas
	public GetDatasPatient getDatasPatient(String document) {
		GetDatasPatient datasIsntance =null;		
		Optional<Patient> number = repository.findByCpf(document);
		if(number.isPresent()){						
			datasIsntance = new GetDatasPatient(
					number.get().getId(), 
					number.get().getFullname(),
					number.get().getBirthDate(),
					number.get().getCpf(),
					number.get().getRg()
					);
			
		}else {
			throw new BusinessExceptio("This Patient not exist");
		}
		return datasIsntance;
	}

	//getAll
	public List<GetDatasPatient> getAll(List<Patient> pat) {
		List<GetDatasPatient> dataP = new ArrayList<>();
		pat.stream().forEach(i ->{
			GetDatasPatient dto = new GetDatasPatient(i);
			dataP.add(dto);
		});
		return dataP;
	}

	
	
}
