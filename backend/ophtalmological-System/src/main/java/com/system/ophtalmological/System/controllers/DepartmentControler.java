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

import com.system.ophtalmological.System.components.Department.AllDepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentSave;
import com.system.ophtalmological.System.entity.Department;
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
	
	//getAll
	@GetMapping(value="/departments")
	public ResponseEntity<List<AllDepartmentDto>> getAll() {
		List<AllDepartmentDto> save = service.getAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	//update
	@PutMapping(value="/update")
	public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentSave data) {
		DepartmentDto save = service.update(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	//getByname
	@GetMapping(value="/departmentName")
	public ResponseEntity<DepartmentDto> getName(@RequestBody DepartmentSave data) {
		DepartmentDto save = service.getByname(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}
	
	//delete
	@DeleteMapping(value="/delete")
	public ResponseEntity<DepartmentDto> delete(@RequestBody DepartmentSave data) {
		DepartmentDto save = service.delete(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);
	}

}
