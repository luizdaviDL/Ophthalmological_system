package com.system.ophtalmological.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Table(name="recepcionist")
@Entity
public class Recepcionist extends Clerk{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Recepcionist(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate, Department department, Long id) {
		super(fullname, cpf, rg, email, matherName, fatherName, birthDate, department);
		this.id = id;
	}
	

}
