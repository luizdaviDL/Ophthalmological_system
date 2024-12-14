package com.system.ophtalmological.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.system.ophtalmological.System.components.patients.SearchByDocumentPatient;
import com.system.ophtalmological.System.controllers.PatientController;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.system.ophtalmological.System.components"})
public class OphtalmologicalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OphtalmologicalSystemApplication.class, args);
		
	}

}
