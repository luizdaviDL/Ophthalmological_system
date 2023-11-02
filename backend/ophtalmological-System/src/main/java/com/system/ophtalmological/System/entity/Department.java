package com.system.ophtalmological.System.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="department")
@Entity
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany
	private List<Clerk> clerk = new ArrayList<>();
	
	public Department(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Department() {
		super();
	}
	
}
