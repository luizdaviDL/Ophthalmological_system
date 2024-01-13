package com.system.ophtalmological.System.components.Department;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Department;

@Component
public class DepartmentData {
	
	@Autowired
	private  ModelMapper mapper;

	//Transform data to Class
	public Department departmentData(DepartmentSave data) {
		return mapper.map(data, Department.class);		
	}


	public List<AllDepartmentDto> getAll(List<Department> data) {
	    List<AllDepartmentDto> list = new ArrayList<>();
	    data.stream().forEach(i -> {
	        //ClerkDto dtoClerck = null;  // Inicialize dentro do loop interno
	        i.getClerk().stream().forEach(value -> {
	        	ClerkDto dtoClerck = new ClerkDto(value);
	            AllDepartmentDto dto = new AllDepartmentDto(i);
		        dto.setClerk(dtoClerck);
		        list.add(dto);
	        });
	        
	    });
	    return list;
	}
	
	/*public List<ClerkDto> clerksDtoList(List<ClerkDto> list){
		List<ClerkDto> listClerk = new ArrayList<>();
		try {			
			list.stream().forEach(i ->{
				//DepartmentDto departmentDto = new DepartmentDto(i.getDepartment());
				ClerkDto dto = new ClerkDto(i);
				listClerk.add(dto);
			});
		}catch(Exception e) {			
			System.out.print(e);
		}
		
		return listClerk;
	}*/
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
