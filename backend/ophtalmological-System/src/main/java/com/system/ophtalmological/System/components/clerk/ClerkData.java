package com.system.ophtalmological.System.components.clerk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentData;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Component
public class ClerkData {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	public ClerckRepository repository;
	@Autowired
	public AppointmentData dataAppointment;
	@Autowired	
	public DepartmentRepository DepartmenRepositoty;
	@Autowired
	public AppointmentRepository appointmentRepository;
	
	
	public Clerk clerkData(ClerkToEntity data) {
		Clerk toData = null;
		try {
			toData = mapper.map(data, Clerk.class);
			toData.setDepartment(data.getDepartment());
			toData.getEspeciality().addAll(data.getEspeciality());
		}catch(Exception e){
			return null;
		}
		
		return toData;
	}
	
	
	public Clerk clerkData(ClerkSave data, Department department, List<Appointment> appointments) {
		Clerk toData = null;
	
		try {
			toData = new Clerk(data, department,appointments);
				
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
		
		return toData;
	}
	 
	
	public List<ClerkDto> clerksDto(List<Clerk> data){
		List<ClerkDto> listClerk = new ArrayList<>();
		try {			
			data.stream().forEach(i ->{
				DepartmentDto departmentDto = new DepartmentDto(i.getDepartment());
				List<AppointmentDto> dtoAppointment = dataAppointment.getAll(i.getEspeciality());
				ClerkDto dto = new ClerkDto(i,departmentDto,dtoAppointment);
				listClerk.add(dto);
			});
		}catch(Exception e) {			
			System.out.print(e);
		}
		
		return listClerk;
	}

	public String findDocument(String document) {
		String value = null;
		try {			
			Optional<Clerk> fingDocument = repository.findByCpf(document);
			if(fingDocument.isPresent()) {			
				value = fingDocument.get().getCpf();
			}
		}catch(Exception e) {
			value = null;
			System.out.print(e);
		}
		
		return value;
	}


	public Clerk clerkData(ClerkSave data, Department department) {
		Clerk toData = null;
		try {
			toData = mapper.map(data, Clerk.class);
			toData.setDepartment(department);		
		}catch(Exception e){
			System.out.print(e);
		}
		
		return toData;
	}

	public void setEspecialityF(List<Appointment> appointments, Clerk toData) {
		appointments.stream().forEach(i ->{
			Optional<Appointment> get = appointmentRepository.findById(i.getId());
			if(get.isPresent()) {
				toData.getEspeciality().add(get.get());
				i.getDoctors().add(toData);
			}
		});
	}
		
	public Clerk saveClerk(ClerkSave data, Department department) {
		Clerk save = null;
		
		List<Appointment> appointments = dataAppointment.getAppointments(data.getEspeciality());
		
		if(appointments !=null || appointments ==null && data.getId()==null) {
			
			Clerk entity = clerkData(data, department, appointments);	
			entity.setDtype("Clerk");
			save = repository.save(entity);				
			DepartmenRepositoty.save(department);
		
			//department dont update in database
		}else if(appointments !=null || appointments ==null  && data.getId()!=null){
			Optional<Clerk> getId = repository.findById(data.getId());
			if(getId.get().getDepartment().getId() != department.getId()){
				Clerk entity = clerkData(data, department, appointments);
				entity.setDtype("Clerk");
				save = repository.save(entity);	
				department.setDepartment(save.getId(),department);
				DepartmenRepositoty.save(department);
				//DepartmenRepositoty.save(save.getDepartment());				
			}
			else if(appointments !=null || appointments ==null && getId.get().getDepartment().getId().equals(department.getId())){
				Clerk entity = clerkData(data, department, appointments);		
				save = repository.save(entity);
				
			}
		}
		return save;
	}
	
	public ClerkDto saveDepartment_Appointment(Department department, Clerk clerk) {
		
		ClerkDto dto = null; 		
		Clerk findClerk = department.findClerk(clerk.getId());
		if(findClerk==null) {
			department.setClerk(clerk); 
			DepartmenRepositoty.save(department);
		}
		
		clerk.getEspeciality().stream()
		.forEach(value -> clerk.getEspeciality().add(value));
		
		DepartmentDto departmentDto = new DepartmentDto(clerk.getDepartment());
		
		List<AppointmentDto> dtoAppointment = dataAppointment.getAll(clerk.getEspeciality());
		if(dtoAppointment !=null) {
			dto = new ClerkDto(clerk,departmentDto,dtoAppointment);
		}
		dto = new ClerkDto(clerk,departmentDto);
		return dto;
	}
	
	
/*
	public Set<Appointment> createInstanteAppointment(List<Appointment> data) {
		Set<Appointment> result = new HashSet<>();
		data.stream().forEach(i ->{
			Optional<Appointment> value = appointmentRepository.findByname(i.getName());
			if(value.isPresent()) {
				result.add(value.get());
			}			
		});
		
		return result;
	}
	
	public void removeAll(List<Appointment> data) {
		data.stream().forEach(i ->{
			data.removeAll(i.getDoctors());
		});
		
	}
	
	public List<Appointment> saveValues(List<Appointment> data, Set<Appointment> listValue) {
	
		data.stream().forEach(i ->{
			i.getDoctors().stream().forEach(value ->{
				result = value.getEspeciality().addAll(listValue);
			});
		});
		//return ;
	}
	*/
}
