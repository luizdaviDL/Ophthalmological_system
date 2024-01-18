package com.system.ophtalmological.System.components.doctor;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoctorToEntity {
	
	private String fullname;
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;	
	private Department department;
	private List<Appointment> especiality;
	
	public DoctorToEntity(DoctorSave data, Department department, List<Appointment> appointments) {
		super();
		this.fullname = data.getFullname();
		this.cpf = data.getCpf();
		this.rg = data.getRg();
		this.email = data.getEmail();
		this.matherName = data.getMatherName();
		this.fatherName = data.getFatherName();
		this.birthDate = data.getBirthDate();
		this.department = department;
		this.especiality = new ArrayList<>();
		this.especiality.addAll(appointments);
		
	}
	
}
