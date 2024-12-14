package com.system.ophtalmological.System.components.report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class saveReport {
	private Long id;
	private String name;
	
	public saveReport(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public saveReport() {
		super();
	}
	
	
}
