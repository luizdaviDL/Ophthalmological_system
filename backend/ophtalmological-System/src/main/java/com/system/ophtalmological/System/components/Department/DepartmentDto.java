package com.system.ophtalmological.System.components.Department;

import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DepartmentDto {

	private Long id;
	private String name;
	
	public DepartmentDto(Department saveDepart) {
		this.id = saveDepart.getId();
		this.name = saveDepart.getName();
	}

}
