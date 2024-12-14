package com.system.ophtalmological.System.components.appointment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppointmentSave {
	private Long id;
	private String name;
	/*@JsonCreator
	public AppointmentSave(@JsonProperty("name")String name) {
		super();
		this.name = name;
	}*/
	@JsonCreator
	public AppointmentSave(String name) {
		super();
		this.name = name;
	}
	

}
