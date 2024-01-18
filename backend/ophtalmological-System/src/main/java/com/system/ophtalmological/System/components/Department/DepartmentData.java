package com.system.ophtalmological.System.components.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Department;

@Component
public class DepartmentData {
	
	@Autowired
	private  ModelMapper mapper;
	@Autowired
	public ClerkData components;

	//Transform data to Class
	public Department departmentData(DepartmentSave data) {
		return mapper.map(data, Department.class);		
	}

	
	public List<AllDepartmentDto> getAll(List<Department> data) {
	    Map<Long, List<ClerkDto>> clerkMap = data.stream()
	            .collect(Collectors.toMap(
	                    Department::getId,
	                    d -> components.clerksDto(d.getClerk())
	            ));

	    return data.stream()
	            .map(d -> new AllDepartmentDto(d, clerkMap.getOrDefault(d.getId(), new ArrayList<>())))
	            .collect(Collectors.toList());
	}


	public List<ClerkDto> getDepartmentData(Department department) {
		List<ClerkDto> clercks = null;
		try {
			clercks = components.clerksDto(department.getClerk());
		}catch(Exception e) {
			System.out.print(e);
		}
		return  clercks ;
	}
	
	
	/*
	public List<DepartmentDto> departmentList(Department i, List<ClerkDto> clerck) {
		List<DepartmentDto> dto = null;
		try {
			dto =  clerck.stream()
					.map(ClerkDto -> new DepartmentDto(i, ClerkDto))
					.collect(Collectors.toList());
			
		}catch(Exception e) {
			System.out.print(e);;
		}
		return dto;
		
	}*/
}
