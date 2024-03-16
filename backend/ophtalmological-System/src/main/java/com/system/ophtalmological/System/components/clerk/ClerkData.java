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
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.ClerckRepository;

@Component
public class ClerkData {
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	public ClerckRepository repository;
	@Autowired
	public AppointmentRepository appointmentRepository;
	
	
	public Clerk clerkData(ClerkToEntity data) {
		Clerk toData = null;
		try {
			toData = mapper.map(data, Clerk.class);
			toData.setDepartment(data.getDepartment());
			toData.getEspeciality().addAll(data.getEspeciality());
		}catch(Exception e){
			System.out.print(e);
		}
		
		return toData;
	}
	
	
	public List<ClerkDto> clerksDto(List<Clerk> data){
		List<ClerkDto> listClerk = new ArrayList<>();
		try {			
			data.stream().forEach(i ->{
				DepartmentDto departmentDto = new DepartmentDto(i.getDepartment());
				ClerkDto dto = new ClerkDto(i,departmentDto);
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

	
	public Clerk clerkData(ClerkSave data, Department department, List<Appointment> appointments) {
		Clerk toData = null;
		Set<Appointment> list = new HashSet<>();
		
		try {
			toData = mapper.map(data, Clerk.class);
			toData.setDepartment(department);	
			toData.getEspeciality().addAll(appointments);
			//toData.getEspeciality().addAll(appointments);
			//setEspecialityF(appointments, toData);
				
		}catch(Exception e){
			System.out.print(e);
		}
		
		return toData;
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
