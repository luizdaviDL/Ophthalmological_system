package com.system.ophtalmological.System.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="appointment")
@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "especiality")
	private List<Clerk> doctors = new ArrayList<>();
	

	public Appointment() {
		super();
	}

	public Appointment(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Clerk findClerk(Long id) {
		return doctors.stream()
		.filter(value-> value.getId().equals(id)).findFirst()
		.orElse(null);
				
	}
	

	
}
