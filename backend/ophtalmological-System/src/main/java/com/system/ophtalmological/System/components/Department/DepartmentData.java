package com.system.ophtalmological.System.components.Department;

import java.util.ArrayList;
import java.util.List;

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

	public List<DepartmentDto> getAll(List<Department> data) {
		List<DepartmentDto> list = new ArrayList<>();
		data.stream().forEach(i ->{
			DepartmentDto dto = new DepartmentDto(i);
			list.add(dto);
		});
		return list;
	}
	
}
