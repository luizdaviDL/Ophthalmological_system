package com.system.ophtalmological.System.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.services.ClerkService;

@RestController
@RequestMapping(value="/clerk")
public class ClerkController {

	@Autowired
	private ClerkService service;
	//save
	@PostMapping
	public ClerkDto save(@RequestBody ClerkSave data){
		ClerkDto save = service.save(data);
		return save;
		
	}
}