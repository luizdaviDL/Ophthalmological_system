package com.system.ophtalmological.System.entity;

import java.util.List;

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
	
	public Clerk(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate);
	}
	
	public Clerk() {
		super();
	}

	
}
