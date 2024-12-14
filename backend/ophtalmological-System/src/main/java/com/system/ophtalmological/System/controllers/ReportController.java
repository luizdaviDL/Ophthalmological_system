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

import com.system.ophtalmological.System.components.report.ReportDto;
import com.system.ophtalmological.System.components.report.saveReport;
import com.system.ophtalmological.System.services.ReportService;

@RestController
@RequestMapping(value="/report")
public class ReportController {
	@Autowired
	private ReportService service;
	
	@PostMapping
	private ResponseEntity<ReportDto> save(@RequestBody saveReport data) {
		ReportDto savedto = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedto);	
	}
	
	@GetMapping(value="/reports")
	private ResponseEntity<List<ReportDto>> getAll() {
		List<ReportDto> getall = service.getAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(getall);	
	}
	
	@GetMapping(value="/reportname")
	private ResponseEntity<ReportDto> getByName(@RequestBody saveReport data) {
		ReportDto element = service.getByName(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(element);	
	}
	
	@PutMapping(value="/reportupdate")
	private ResponseEntity<ReportDto> update(@RequestBody saveReport data) {
		ReportDto element = service.update(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(element);	
	}
	
	@DeleteMapping(value="/delete")
	private ResponseEntity<List<ReportDto>> delete(@RequestBody saveReport data) {
		List<ReportDto> element = service.delete(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(element);	
	}
}
