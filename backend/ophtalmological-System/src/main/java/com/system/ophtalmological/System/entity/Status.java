package com.system.ophtalmological.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter@Table(name="status")
@Entity
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	public Status(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
