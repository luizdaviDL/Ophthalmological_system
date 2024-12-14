package com.system.ophtalmological.System.components.clerk;

import com.system.ophtalmological.System.components.Department.DepartmentDto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClerkDto2 {
	private Long id;
	private String fullname;		
	private String birthDate;
	private DepartmentDto department;
	
	

}
