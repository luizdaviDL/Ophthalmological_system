package com.system.ophtalmological.System.components.clerk;

import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClerkDto {
	private Long id;
	private String fullname;		
	private String email;
	private String birthDate;
	private DepartmentDto department;
	public ClerkDto() {
		super();
	}
	public ClerkDto(Long id, String fullname, String email, String birthDate, DepartmentDto department) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.birthDate = birthDate;
		this.department = department;
	}
		
}
