package com.system.ophtalmological.System.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentSave;
import com.system.ophtalmological.System.services.DepartmentService;

@RestController
@RequestMapping(value="/department")
public class DepartmentControler {
	
	@Autowired
	private DepartmentService service;

	@PostMapping
	public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentSave data) {
		DepartmentDto save = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	
}
