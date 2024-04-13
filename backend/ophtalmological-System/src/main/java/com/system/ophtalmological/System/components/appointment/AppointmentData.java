package com.system.ophtalmological.System.components.appointment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.repository.AppointmentRepository;

@Component
public class AppointmentData {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	public AppointmentRepository repositoryAppointment;


	public Appointment dataClass(AppointmentSave data) {
		return mapper.map(data, Appointment.class);
	}


	public List<AppointmentDto> getAll(List<Appointment> get){
		try {
			List<AppointmentDto> listAp = new ArrayList<>();
			
			get.forEach(i ->{
				System.out.println("Nome "+i.getName());
				System.out.println("Id "+ i.getId());
				AppointmentDto dto = new AppointmentDto(i);
				listAp.add(dto);
			});
			return listAp;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public List<Appointment> getAppointments(List<Long> list){
		List<Appointment> listAp = new ArrayList<>();
		try {			
			list.forEach(i ->{
				Optional<Appointment> result = repositoryAppointment.findById(i);
				if(result.isPresent()) {
					listAp.add(result.get());
				}
			});
		}catch(Exception e) {
			return null;
		}		
		return listAp;
	}
	public List<Appointment> getAppointmentL(List<Appointment> list){
		List<Appointment> listAp = new ArrayList<>();
		try {			
			list.forEach(i ->{
				Optional<Appointment> result = repositoryAppointment.findById(i.getId());
				if(result.isPresent()) {
					listAp.add(result.get());
				}
			});
		}catch(Exception e) {
			return null;
		}		
		return listAp;
	}
	
}
