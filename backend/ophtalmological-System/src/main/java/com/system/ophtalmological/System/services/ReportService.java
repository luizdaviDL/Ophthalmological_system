package com.system.ophtalmological.System.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.report.ReportData;
import com.system.ophtalmological.System.components.report.ReportDto;
import com.system.ophtalmological.System.components.report.saveReport;
import com.system.ophtalmological.System.entity.Report;
import com.system.ophtalmological.System.repository.ReportRepository;


@Service
public class ReportService {
	@Autowired
	private ReportData datareport;
	@Autowired
	private ReportRepository repository;
	

	public ReportDto save(saveReport data) {
		ReportDto dto=null;
		
		Report toEntity = datareport.departmentData(data);
		System.out.println(':'+toEntity.getName());
		Report name = repository.findByName(toEntity.getName());
		if(name==null) {
			Report saving = datareport.savingValue(toEntity);
			dto = new ReportDto(saving);
		}else {
			throw new BusinessExceptio("This report already exist");
		}
		
		return dto;
	}

	public List<ReportDto> getAll() {
		List<ReportDto> dto=new ArrayList<>();
		
		List<Report> getAll = repository.findAll();
		getAll.stream().forEach(i->{
			dto.add(new ReportDto(i));
		});
		return dto;
	}

	public ReportDto getByName(saveReport data) {
		ReportDto dto=null;
		
		Report toEntity = datareport.departmentData(data);
		System.out.println(':'+toEntity.getName());
		Report name = repository.findByName(toEntity.getName());
		if(name==null) {
			throw new BusinessExceptio("This report not exist");
			
		}else{
			dto = new ReportDto(name);
		}
		
		return dto;
	}

	public ReportDto update(saveReport data) {
		ReportDto dto=null;
		
		Report toEntity = datareport.departmentData(data);
		Optional<Report> name = repository.findById(toEntity.getId());
		if(name.isEmpty()) {
			throw new BusinessExceptio("This report not exist");
			
		}else{
			Report saving = datareport.savingValue(toEntity);
			dto = new ReportDto(saving);
		}
		
		return dto;
	}

	public List<ReportDto> delete(saveReport data) {
		List<ReportDto> dto=new ArrayList<>();
		Optional<Report> name = repository.findById(data.getId());
		if(name.isPresent()) {
			repository.deleteById(data.getId());
			dto = getAll();
		}else{
			throw new BusinessExceptio("This report not exist");
		}
		
		return dto;
	}
	
}
