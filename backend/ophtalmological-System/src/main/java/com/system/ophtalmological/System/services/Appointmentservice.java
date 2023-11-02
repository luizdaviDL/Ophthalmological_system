package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.appointment.AppointmentData;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentDtoDoctor;
import com.system.ophtalmological.System.components.appointment.AppointmentSave;
import com.system.ophtalmological.System.components.appointment.DoctorDto;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Doctor;
import com.system.ophtalmological.System.repository.AppointmentRepository;

@Service
public class Appointmentservice {
	@Autowired
	private AppointmentRepository repository;
	@Autowired
	private AppointmentData dataClass;
	
	//save
	public AppointmentDto saveAppointment(AppointmentSave data) {
		AppointmentDto dto = null;
		
		Appointment clas = dataClass.dataClass(data);
		Optional< Appointment> appointment = repository.findByname(clas.getName());
		if(appointment.isPresent()) {
			throw new BusinessExceptio("Appointment already exist");
		}else {
			//transform saveDto to class
			System.out.print("Chegou os dados 2");
			Appointment save = repository.save(clas);
			dto = new AppointmentDto(save);
		}
		return dto;
	}

	public List<AppointmentDto> getAll() {
		List<Appointment> get = repository.findAll();
		//Appointment clas = dataClass.dataClass(get);
		List<AppointmentDto> dto = dataClass.getAll(get);
		return dto;
	}
	
	//update
	public AppointmentDto update(AppointmentSave data) {
		AppointmentDto dto = null;		
		Appointment clas = dataClass.dataClass(data);
		Appointment save = repository.save(clas);
		dto = new AppointmentDto(save);
		return dto;
		
	}

	public AppointmentDtoDoctor getByName(AppointmentSave data) {
		//search the appointment name 
		Optional<Appointment> appointment = repository.getByname(data.getName());
		//instantiating AppointmentDtoDoctor
		AppointmentDtoDoctor result = new AppointmentDtoDoctor();
		if(appointment.isPresent()) {			
			//getting the appointment class	
			Appointment aptvalue = appointment.get();
			//setting 	appointment value	
			result.setId(aptvalue.getId());
			result.setName(aptvalue.getName());
			
			//checking if Doctor list have values
			if(!aptvalue.getDoctors().isEmpty()) {
				//for each doctor in the list setting in to DoctorDto and setting doctors too
				aptvalue.getDoctors().stream().forEach(i->{
					DoctorDto dtoDc = new DoctorDto();
					dtoDc.setId(i.getId());
					dtoDc.setFullname(i.getFullname());
					dtoDc.setEspecialty(i.getEspecialty());
					result.setDoctors(dtoDc);
				});
			}
						
		}
		return result;
	}

	/*public AppointmentDtoDoctor delete(AppointmentSave data) {
		Appointment value = dataClass.dataClass(data);
		Optional<Appointment> appointment = repository.findById(value.getId());
		if(appointment.isPresent()) {
			repository.delete(value);
		}
		return null;
	}*/

	public AppointmentDtoDoctor delete(Long id) {
		Optional<Appointment> appointment = repository.findById(id);
		
		if(appointment.isPresent()) {			
			repository.deleteById(id);
		}
		return null;
	}

}



















