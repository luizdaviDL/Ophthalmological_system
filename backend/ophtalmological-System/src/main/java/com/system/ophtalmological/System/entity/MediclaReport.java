package com.system.ophtalmological.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="report")
@Entity
public class MediclaReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Patient patient;
	@OneToOne
	private Clerk doctor;
	private String report;
}
