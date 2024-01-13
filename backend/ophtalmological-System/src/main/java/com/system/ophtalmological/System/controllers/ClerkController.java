package com.system.ophtalmological.System.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.clerk.ClerkDocument;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.services.ClerkService;

@RestController
@RequestMapping(value="/clerk")
public class ClerkController {

	@Autowired
	private ClerkService service;
	
	@PostMapping
	public ResponseEntity<ClerkDto> save(@RequestBody ClerkSave data){
		ClerkDto save = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);			
	}
	
	@PutMapping(value="/updateClerck")
	public ResponseEntity<ClerkDto> update(@RequestBody ClerkSave data){
		ClerkDto save = service.updateClerck(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);			
	}
	
	@GetMapping(value="/clerks")
	public ResponseEntity<List<ClerkDto>> getAll() {
		List<ClerkDto> clerks = service.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(clerks);		
	}
	
	@GetMapping(value="/clerkDocument")
	public ResponseEntity<ClerkDto> findByDocument(@RequestBody ClerkDocument data) {		
		ClerkDto clerk = service.getDocument(data);
		return ResponseEntity.status(HttpStatus.OK).body(clerk);	
	}
	
	@DeleteMapping
	public ResponseEntity<List<ClerkDto>> delete(@RequestBody ClerkSave data){
		List<ClerkDto> save = service.deleteClerck(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);			
	}
	
}