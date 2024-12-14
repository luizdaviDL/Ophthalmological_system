package com.system.ophtalmological.System.components.report;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.entity.Report;
import com.system.ophtalmological.System.repository.ReportRepository;


@Component
public class ReportData {
	@Autowired
	private  ModelMapper mapper;
	@Autowired
	private ReportRepository repository;

	public Report departmentData(saveReport data) {
		return mapper.map(data, Report.class);		
	}
	
	public Report savingValue(Report data){
		Report saving = repository.save(data);
		return saving;
	}
}
