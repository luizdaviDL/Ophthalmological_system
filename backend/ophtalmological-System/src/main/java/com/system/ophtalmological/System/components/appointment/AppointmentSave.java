package com.system.ophtalmological.System.components.appointment;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AppointmentSave {
	private Long id;
	private String name;
	private String observation;
	private LocalTime timeDuration;
	private List<String> services;

	public AppointmentSave(Long id, String name, String observation, LocalTime timeDuration, List<String> services) {
		this.id = id;
		this.name = name;
		this.observation = observation;
		this.timeDuration = timeDuration;
		this.services = services;
	}
}
