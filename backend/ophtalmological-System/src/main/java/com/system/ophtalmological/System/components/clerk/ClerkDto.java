package com.system.ophtalmological.System.components.clerk;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ClerkDto {
	private Long id;
	private String fullname;		
	private String birthDate;
	private DepartmentDto department;
	private List<AppointmentDto> especiality;

	public ClerkDto() {
		super();
	}
	public ClerkDto(Clerk save, DepartmentDto department,List<AppointmentDto> data) {
		super();
		this.id = save.getId();
		this.fullname = save.getFullname();
		this.birthDate = save.getBirthDate();
		this.department = department;
		this.especiality = new ArrayList<>();
		this.especiality.addAll(data);
	}
	
	public ClerkDto(Clerk save, DepartmentDto department) {
		super();
		this.id = save.getId();
		this.fullname = save.getFullname();
		this.birthDate = save.getBirthDate();
		this.department = department;
	}
	
	public ClerkDto(ClerkSave i) {
		super();
		this.id = i.getId();
		this.fullname = i.getFullname();
		this.birthDate = i.getBirthDate();
		//this.department = i.getDepartment();
	}
	public ClerkDto(Clerk i) {
		super();
		this.id = i.getId();
		this.fullname = i.getFullname();
		this.birthDate = i.getBirthDate();
	}
	
	
	
	
		
}
