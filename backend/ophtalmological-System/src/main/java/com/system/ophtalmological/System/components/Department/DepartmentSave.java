package com.system.ophtalmological.System.components.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentSave {
	private Long id;
	private String name;
	
	public DepartmentSave() {
		super();
	}
	public DepartmentSave(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	
}
