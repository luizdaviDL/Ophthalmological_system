package com.system.ophtalmological.System.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.ophtalmological.System.components.diary.DiaryDto;
import com.system.ophtalmological.System.components.diary.DiarySave;
import com.system.ophtalmological.System.services.DiaryService;

@RestController
@RequestMapping(value="/diary")
public class DiaryController {
	@Autowired
	private DiaryService service;
	
	@PostMapping
	public ResponseEntity<DiaryDto> save(@RequestBody DiarySave data) throws ParseException{
		DiaryDto save = service.save(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(save);			
	}
	
	
	@DeleteMapping(value="/delete")
	public ResponseEntity<List<DiaryDto>> delete(@RequestBody DiarySave data) {
		List<DiaryDto> delete = service.delete(data);
		return ResponseEntity.status(HttpStatus.CREATED).body(delete);	
	}

	@GetMapping(value="/Alldiary")
	public ResponseEntity<List<DiaryDto>> getAll() {
		List<DiaryDto> getAll = service.getAll();
		return ResponseEntity.status(HttpStatus.CREATED).body(getAll);	
	}
	
	
}
