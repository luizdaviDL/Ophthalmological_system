package com.system.ophtalmological.System.components.Department;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Department;

@Component
public class DepartmentData {
	
	@Autowired
	private  ModelMapper mapper;

	//Transform data to Class
	public Department departmentData(DepartmentSave data) {
		return mapper.map(data, Department.class);		
	}

	
}
