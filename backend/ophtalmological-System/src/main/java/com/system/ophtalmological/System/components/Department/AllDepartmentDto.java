package com.system.ophtalmological.System.components.Department;

import java.util.List;

import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllDepartmentDto {
	
	private Long id;
	private String name;
	private List<ClerkDto> clerk;
	
	
	public AllDepartmentDto(Department i, List<ClerkDto> list) {
		this.id = i.getId();
		this.name = i.getName();
		this.clerk = list;
	}

	public void setClerk(ClerkDto dtoClerck) {
		this.clerk.add(dtoClerck);
	}
}
