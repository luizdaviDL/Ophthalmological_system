package com.system.ophtalmological.System.components.Department;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DepartmentDto {

	private Long id;
	private String name;
	//private List<ClerkDto> clerk;
	
	public DepartmentDto() {
		super();
	}

/*
	public DepartmentDto(Department i, ClerkDto clerck) {
		super();
		this.id = i.getId();
		this.name = i.getName();	
		this.clerk = clerck;
		
	}*/

	public DepartmentDto(Department i) {
		super();
		this.id = i.getId();
		this.name = i.getName();		
	}

	
}
