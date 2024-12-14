package com.system.ophtalmological.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentDtoDoctor;
import com.system.ophtalmological.System.components.appointment.AppointmentSave;
import com.system.ophtalmological.System.services.Appointmentservice;
@RestController
@RequestMapping(value="/appointment")
public class AppointmentController {
	@Autowired
	private Appointmentservice service;
	
	//save
	@PostMapping
	public ResponseEntity<AppointmentDto> save(@RequestBody AppointmentSave data) {
		System.out.print("Chegou os dados");
		AppointmentDto servic = service.saveAppointment(data);		
		return ResponseEntity.status(HttpStatus.CREATED).body(servic);		
	}
	
	//update
	@PutMapping(value="/update")
	public ResponseEntity<AppointmentDto> update(@RequestBody AppointmentSave data ) {
		AppointmentDto servic = service.update(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(servic);		
	}
	
	//get all
	@GetMapping(value="/appointments")
	public ResponseEntity<List<AppointmentDto>> getAll() {
		List<AppointmentDto> servic = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(servic);		
	}
	
	//getByname
	
	/*
	@GetMapping(value="/appointmentvalue")
	public ResponseEntity<AppointmentDtoDoctor> getByName(@RequestBody AppointmentSave data) {
		AppointmentDtoDoctor servic = service.getByName(data);
		return ResponseEntity.status(HttpStatus.OK).body(servic);
	}
	*/
	
	//delete
	@DeleteMapping
	public ResponseEntity<AppointmentDtoDoctor> delete(@RequestBody AppointmentSave data) {
		AppointmentDtoDoctor servic = service.delete(data.getId());
		return ResponseEntity.status(HttpStatus.OK).body(servic);
	}
	
	
	
}
