package com.system.ophtalmological.System.entity;

import java.util.ArrayList;
import java.util.List;

import com.system.ophtalmological.System.components.clerk.ClerkSave;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="clerk")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Clerk extends Person{
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;

	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "clerk_especiality",
        joinColumns = @JoinColumn(name = "clerk_id"),
        inverseJoinColumns = @JoinColumn(name = "especiality_id"))
	private List<Appointment> especiality;


	private String dtype;
	
	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
	}
	
	public Clerk() {
		super();
	}

	public Clerk(ClerkSave data ,Department department, List<Appointment> especiality) {
		super(data.getFullname(), data.getCpf(), data.getRg(), data.getEmail(), data.getMatherName(), data.getFatherName(),data.getBirthDate());
		this.especiality = new ArrayList<>();
		this.department = department;
		if(especiality!=null) {
			this.especiality.addAll(especiality);
		}
	}

	public void setDtype(String string) {
	    this.dtype = string;
	}

	
	
	
}
