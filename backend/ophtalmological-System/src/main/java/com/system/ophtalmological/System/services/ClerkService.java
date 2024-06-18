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

import jakarta.transaction.Transactional;

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
		
		//List<Appointment> appointments = dataAppointment.getAppointments(data.getEspeciality());		
		Optional<Department> department = DepartmenRepositoty.findById(data.getDepartment());
		String document = components.findDocument(data.getCpf());		
		try {
			if(document == null) {			
				if(department.isPresent()) {
					save = components.saveClerk(data, department.get());
					List<Appointment> appointments = dataAppointment.getAppointments(data.getEspeciality());
					DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
					List<AppointmentDto> dtoAppointment = dataAppointment.getAll(appointments); /*save.getEspeciality()*/
					dto = new ClerkDto(save,departmentDto,dtoAppointment);
				}else {
					throw new BusinessExceptio("Erro in the process");
				}				
			}else{ 
				throw new BusinessExceptio("Clerk already exist"); 
			}
										
		}catch(Exception e) {	
			System.out.println(e);
			return null;
		}
		
		return dto;
	}
	
	public List<ClerkDto> getAll() {
		List<Clerk> clerks =  repository.findAll();
		List<ClerkDto> list = components.clerksDto(clerks);
		return list; 
	}

	public ClerkDto getDocument(ClerkDocument data) {
		System.out.println("Documento" +data.getCpf()); 
		ClerkDto dto = null; 	
		//String document = components.findDocument(data.getCpf());
		Optional<Clerk> fingDocument = repository.findByCpf(data.getCpf());		
		if(fingDocument.isPresent()) {			
			DepartmentDto departmentDto = new DepartmentDto(fingDocument.get().getDepartment());
			List<AppointmentDto> dtoAppointment = dataAppointment.getAll(fingDocument.get().getEspeciality());
			dto = new ClerkDto(fingDocument.get(),departmentDto,dtoAppointment);
		}else {
			throw new BusinessExceptio("This clerck not exist");
		}
		return dto;
	}

	public ClerkDto updateClerck(ClerkSave data) {
		Clerk save = null; 		
		ClerkDto dto = null; 
		try {

			List<Appointment> appointments = dataAppointment.getAppointments(data.getEspeciality());
			Optional<Clerk> getId = repository.findById(data.getId());
			Optional<Department> department = DepartmenRepositoty.findAllById(data.getDepartment());
			if(getId.isPresent() && department.isPresent()) {			
				save = components.saveClerk(data, department.get());
				DepartmentDto departmentDto = new DepartmentDto(department.get());
				//List<Appointment> appointments = dataAppointment.getAppointments(data.getEspeciality());
				List<AppointmentDto> dtoAppointment = dataAppointment.getAll(appointments);///save.getEspeciality(
				dto = new ClerkDto(save,departmentDto,dtoAppointment);
			}else {
				throw new BusinessExceptio("Clerk or Department not exist");
			}	
			
		}catch(Exception e) {
			System.out.print(e);
			throw new BusinessExceptio("Erro:"+e);
		}
		
		return dto;
	}

	@Transactional
	public List<ClerkDto> deleteClerck(ClerkSave data) {
		try {
			Appointment app = new Appointment();
			Optional<Clerk> getId = repository.findById(data.getId());
			if(getId.isPresent()) {
				Optional<Department> department = DepartmenRepositoty.findById(getId.get().getDepartment().getId());
				List<Appointment> appointments = dataAppointment.getAppointmentL(getId.get().getEspeciality());
				if(department.isPresent()) {
					try {
						
						repository.deleteClerkFromDepartment(getId.get().getId(), department.get().getId());
						if(appointments.size()>0) {
							appointments.forEach(i->{
								repository.deleteCLerckFromEspeciality(getId.get().getId(), i.getId());
							});
						}
						repository.deleteById(getId.get().getId());
								
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
