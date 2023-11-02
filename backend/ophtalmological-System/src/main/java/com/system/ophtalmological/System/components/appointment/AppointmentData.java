package com.system.ophtalmological.System.components.appointment;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Appointment;

@Component
public class AppointmentData {
	@Autowired
	private ModelMapper mapper;

	public Appointment dataClass(AppointmentSave data) {
		// TODO Auto-generated method stub
		return mapper.map(data, Appointment.class);
	}


	public List<AppointmentDto> getAll(List<Appointment> get){
		List<AppointmentDto> listAp = new ArrayList<>();
		get.stream().forEach(i ->{
			AppointmentDto dto = new AppointmentDto(i);
			listAp.add(dto);
		});
		return listAp;
	}
	
}
