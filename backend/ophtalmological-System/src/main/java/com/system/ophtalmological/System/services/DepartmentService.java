package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.AllDepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentData;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentSave;
import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	@Autowired
	private DepartmentData dataDepartmen;
	@Autowired
	public ClerkData components;
	
	//save
	public DepartmentDto save(DepartmentSave data) {
		DepartmentDto dto = null;
		
		Department transformData = dataDepartmen.departmentData(data);
		Optional<Department> repositoryData = repository.getByname(transformData.getName());
		if(repositoryData.isPresent()) {
			throw new BusinessExceptio("This department already exist");
		}else {
			Department saveDepart = repository.save(transformData);
			dto = new DepartmentDto(saveDepart);
			
		}
		return dto;
	}

	
	public List<AllDepartmentDto> getAll() {
		List<Department> departments = repository.findAll(); 
		List<AllDepartmentDto> getDto = dataDepartmen.getAll(departments);
		return getDto;
	}

	public DepartmentDto update(DepartmentSave data) {
		DepartmentDto dto = null;
		Department transform = dataDepartmen.departmentData(data);
		Optional<Department> repositoryData = repository.findById(transform.getId());
		if(repositoryData.isPresent()) {
			Department save = repository.save(transform);
			dto = new DepartmentDto(save);
		}else {
			throw new BusinessExceptio("This department not exist");
		}
		
		return dto;
	}
	
	
	public List<ClerkDto> getByname(DepartmentSave data) {
		List<ClerkDto> dataResult = null;
		Optional<Department> department = repository.findByName(data.getName());
		if(department.isPresent()) {
			dataResult = dataDepartmen.getDepartmentData(department.get());
		}else {
			throw new BusinessExceptio("This department not exist");
		}
		return dataResult;
	}

	public DepartmentDto delete(DepartmentSave data) {
		DepartmentDto dto = null;
		Department transform = dataDepartmen.departmentData(data);
		Optional<Department> repositoryData = repository.findById(transform.getId());
		if(repositoryData.isPresent()) {			
			repository.delete(transform);
		}else {
			throw new BusinessExceptio("This department not exist");
		}
		return null;
	}
	
	
	
	

}
