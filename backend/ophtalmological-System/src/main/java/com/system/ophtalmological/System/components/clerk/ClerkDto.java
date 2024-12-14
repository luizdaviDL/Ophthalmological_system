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
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
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
		this.department = new DepartmentDto(save.getDepartment());
		for(Appointment va : save.getEspeciality()){
			AppointmentDto values = new AppointmentDto(va);
			especiality.add(values);
		}
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
		this.especiality = new ArrayList<>();
		this.department = new DepartmentDto(i.getDepartment());
		for(Appointment va : i.getEspeciality()){
			AppointmentDto values = new AppointmentDto(va);
			especiality.add(values);
		}
	}


	public Long getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public List<AppointmentDto> getEspeciality() {
		return especiality;
	}
}
