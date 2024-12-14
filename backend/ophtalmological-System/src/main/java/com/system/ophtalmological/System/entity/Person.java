package com.system.ophtalmological.System.entity;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@MappedSuperclass
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)

public abstract class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String fullname;	
	private String cpf;
	private String rg;
	private String email;
	private String matherName;
	private String fatherName;
	private String birthDate;
	
	
	public Person() {
		super();
	}


	public Person(String fullname, String cpf, String rg, String email, String matherName,
			String fatherName, String birthDate) {
		super();
		this.fullname = fullname;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.matherName = matherName;
		this.fatherName = fatherName;
		this.birthDate = birthDate;
	}

}
