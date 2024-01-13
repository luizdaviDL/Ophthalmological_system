package com.system.ophtalmological.System.components.clerk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.ClerckRepository;
@Component
public class ClerkData {
	
	@Autowired
	private ModelMapper mapper;
	@Autowired
	public ClerckRepository repository;

	public Clerk clerkData(ClerkSave data, Department department) {
		Clerk toData = null;
		try {
			toData = mapper.map(data, Clerk.class);
			toData.setDepartment(department);
		}catch(Exception e){
			System.out.print(e);
		}
		
		return toData;
	}
	
	public List<ClerkDto> clerksDto(List<Clerk> data){
		List<ClerkDto> listClerk = new ArrayList<>();
		try {			
			data.stream().forEach(i ->{
				DepartmentDto departmentDto = new DepartmentDto(i.getDepartment());
				ClerkDto dto = new ClerkDto(i,departmentDto);
				listClerk.add(dto);
			});
		}catch(Exception e) {			
			System.out.print(e);
		}
		
		return listClerk;
	}

	public Clerk findDocument(String document) {
		Clerk value = null;
		try {			
			Optional<Clerk> fingDocument = repository.findByCpf(document);
			if(fingDocument.isPresent()) {			
				value = fingDocument.get();
			}
		}catch(Exception e) {
			value = null;
			System.out.print(e);
		}
		
		return value;
	}
	
}
