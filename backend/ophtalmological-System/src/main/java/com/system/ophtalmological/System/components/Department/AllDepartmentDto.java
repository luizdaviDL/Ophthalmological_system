package com.system.ophtalmological.System.components.Department;

import java.util.List;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllDepartmentDto {
	
	private Long id;
	private String name;
	private List<ClerkDto> clerk;
	
	public AllDepartmentDto(Department i) {
		this.id = i.getId();
		this.name = i.getName();
	}

	public void setClerk(ClerkDto dtoClerck) {
		this.clerk.add(dtoClerck);
	}
}
