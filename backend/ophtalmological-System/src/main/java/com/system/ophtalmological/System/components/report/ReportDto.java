package com.system.ophtalmological.System.components.report;

import com.system.ophtalmological.System.entity.Report;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportDto {
	private Long id;
	private String name;
	
	public ReportDto(Report saving) {
		super();
		this.id = saving.getId();
		this.name = saving.getName();
	}

	public ReportDto() {
		super();
	}
	
	

}
