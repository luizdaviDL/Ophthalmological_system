package com.system.ophtalmological.System.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.doctor.DoctorDto;
import com.system.ophtalmological.System.components.doctor.DoctorSave;
import com.system.ophtalmological.System.services.DoctorService;

@RestController
@RequestMapping(value="/doctors")
public class DoctorController {
	
	@Autowired
	private DoctorService service;
	
	
	

}
