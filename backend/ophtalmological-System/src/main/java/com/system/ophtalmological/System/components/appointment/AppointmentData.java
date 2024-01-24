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
		List<AppointmentDto> listAp = new ArrayList<>();
		get.forEach(i ->{
			AppointmentDto dto = new AppointmentDto(i);
			listAp.add(dto);
		});
		return listAp;
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
			System.out.print(e);
		}		
		return listAp;
	}

	
}
