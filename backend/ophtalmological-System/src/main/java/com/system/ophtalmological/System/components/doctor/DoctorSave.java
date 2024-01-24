package com.system.ophtalmological.System.components.doctor;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Department;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class DoctorSave {
	private String fullname;	
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;
	private Long department;	
	private List<Long> especiality;
	
	public DoctorSave(String fullname, String cpf, String rg, String email, String matherName, String fatherName,
			String birthDate, Long department, List<Long> especiality) {
		super();
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
		this.department = department;
		this.especiality = new ArrayList<>();
		this.especiality.addAll(especiality);
	}
	
	
}
