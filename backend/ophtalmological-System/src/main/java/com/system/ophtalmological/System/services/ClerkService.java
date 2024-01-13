package com.system.ophtalmological.System.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDocument;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Service
public class ClerkService {
	
	@Autowired
	public ClerkData components;
	@Autowired
	public ClerckRepository repository;
	@Autowired
	public DepartmentRepository DepartmenRepositoty;
	
	public ClerkDto save(ClerkSave data) {
		ClerkDto dto = null; 
		Optional<Department> department = DepartmenRepositoty.findAllById(data.getDepartment());
		if(department.isPresent()) {
			Clerk clerkToEntity = components.clerkData(data,department.get());
			Clerk save = repository.save(clerkToEntity);
			List<Clerk> clerks = new ArrayList<>();
			clerks.add(save);
			//ClerkDto addClerck = new ClerkDto(data);
			department.get().setClerk(clerks);
			DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
			dto = new ClerkDto(save,departmentDto);
		}else {
			throw new BusinessExceptio("This dapartment not exist");
		}
		
		return dto;
	}
	
	public List<ClerkDto> getAll() {
		List<Clerk> clerks =  repository.findAll();
		List<ClerkDto> list = components.clerksDto(clerks);
		return list;
	}

	public ClerkDto getDocument(ClerkDocument data) {
		ClerkDto dto = null; 	
		Clerk fingDocument = components.findDocument(data.getCpf());
		if(fingDocument!=null) {
			DepartmentDto departmentDto = new DepartmentDto(fingDocument.getDepartment());
			dto = new ClerkDto(fingDocument,departmentDto);
		}else {
			throw new BusinessExceptio("This clerck not exist");
		}
		return dto;
	}

	public ClerkDto updateClerck(ClerkSave data) {
		ClerkDto dto = null; 
		try {
			Optional<Clerk> getId = repository.findById(data.getId());
			Optional<Department> department = DepartmenRepositoty.findAllById(data.getDepartment());
			if(getId.isPresent() && department.isPresent()) {			
				Clerk clerkToEntity = components.clerkData(data,department.get());
				Clerk save = repository.save(clerkToEntity);
				DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
				dto = new ClerkDto(save,departmentDto);
			}
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return dto;
	}

	public List<ClerkDto> deleteClerck(ClerkSave data) {
		try {
			Optional<Clerk> getId = repository.findById(data.getId());
			if(getId.isPresent()) {
				repository.deleteById(data.getId());
			}
			
		}catch(Exception e){
			System.out.print(e);
		}
		
		return getAll();
	}


	
	
	

	
	
	

}
