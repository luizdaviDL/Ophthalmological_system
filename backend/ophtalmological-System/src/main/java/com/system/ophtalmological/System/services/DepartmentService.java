package com.system.ophtalmological.System.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentData;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.Department.DepartmentSave;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	@Autowired
	private DepartmentData dataDepartmen;
	
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

}
