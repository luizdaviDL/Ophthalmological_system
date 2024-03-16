package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentData;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDocument;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Service
public class ClerkService {
	
	@Autowired
	public ClerkData components;
	@Autowired
	public AppointmentData dataAppointment;
	@Autowired
	public ClerckRepository repository;
	@Autowired
	public DepartmentRepository DepartmenRepositoty;
	@Autowired
	public AppointmentRepository appointmentRepository;

	public ClerkDto save(ClerkSave data) {
		ClerkDto dto = null; 
		Clerk save = null;
		List<Appointment> appointments = null;
		
		Optional<Department> department = DepartmenRepositoty.findById(data.getDepartment());
		String document = components.findDocument(data.getCpf());
		System.out.println("Documento: " + document);
		try {
			if(document == null) {
				if(data.getEspeciality() !=null && department.isPresent()) {
					/*List<Appointment>*/ appointments = dataAppointment.getAppointments(data.getEspeciality());
					if(appointments !=null) {					
						Clerk entity = components.clerkData(data, department.get(), appointments);		
						save = repository.save(entity);																	
					}
				}else if(data.getEspeciality() ==null && department.isPresent()) {
					Clerk clerkToEntity = components.clerkData(data,department.get());					
					save = repository.save(clerkToEntity);//essa
													
				}else {
					throw new BusinessExceptio("Erro in the process");
				}
				
				if(department.get().getId().equals(data.getDepartment())) {
					department.get().setClerk(save); 
					DepartmenRepositoty.save(department.get());
				}else {
					throw new BusinessExceptio("Erro to add clerck to list");
				}
				DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
							
				List<AppointmentDto> dtoAppointment = dataAppointment.getAll(appointments);
				System.out.println("DADA" +dtoAppointment);
				dto = new ClerkDto(save,departmentDto,dtoAppointment);//esssa 
			}else if(document != null) { 
				throw new BusinessExceptio("Clerk already exist"); 
			}
										
		}catch(Exception e) {
			System.out.print(e);
		}
		System.out.print("DTO" +dto); 
		
		return dto;
	}
	/*
	public ClerkDto save(ClerkSave data) {
		ClerkDto dto = null; 
		Optional<Department> department = DepartmenRepositoty.findById(data.getDepartment());
		try {
			if(department.isPresent()){
				Clerk clerkToEntity = components.clerkData(data,department.get());
				Clerk save = repository.save(clerkToEntity);
				if(department.get().getId().equals(data.getDepartment())) {
					department.get().getClerk().add(save);
					DepartmenRepositoty.save(department.get());
				}else {
					throw new BusinessExceptio("Erro to add clerck to list");
				}
				DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
				dto = new ClerkDto(save,departmentDto);
			}else {
				throw new BusinessExceptio("This dapartment not exist");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return dto;
	}*/
	
	public List<ClerkDto> getAll() {
		List<Clerk> clerks =  repository.findAll();
		List<ClerkDto> list = components.clerksDto(clerks);
		return list;
	}

	public ClerkDto getDocument(ClerkDocument data) {
		ClerkDto dto = null; 	
		Clerk fingDocument = components.findDocument(data.getCpf());
		if(fingDocument!=null) {
			DepartmentDto departmentDto = new DepartmentDto(fingDocument.getDepartment());
			dto = new ClerkDto(fingDocument,departmentDto);
		}else {
			throw new BusinessExceptio("This clerck not exist");
		}
		return dto;
	}

	public ClerkDto updateClerck(ClerkSave data) {
		ClerkDto dto = null; 
		try {
			Optional<Clerk> getId = repository.findById(data.getId());
			Optional<Department> department = DepartmenRepositoty.findAllById(data.getDepartment());
			if(getId.isPresent() && department.isPresent()) {			
				Clerk clerkToEntity = components.clerkData(data,department.get());
				Clerk save = repository.save(clerkToEntity);
				DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
				dto = new ClerkDto(save,departmentDto);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return dto;
	}

	public List<ClerkDto> deleteClerck(ClerkSave data) {
		try {
			Optional<Clerk> getId = repository.findById(data.getId());
			if(getId.isPresent()) {
				Optional<Department> department = DepartmenRepositoty.findById(getId.get().getDepartment().getId());
				if(department.isPresent()) {
					try {
						department.get().removeClerck(getId.get().getId());
						repository.deleteById(data.getId());
					}catch(Exception e) {
						System.out.print(e);
					}
				}
			}
			
		}catch(Exception e){
			System.out.print(e);
		}
		
		return getAll();
	}


	
	
	

	
	
	

}
