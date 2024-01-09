package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDocument;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.DepartmentRepository;

@Service
public class ClerkService {
	/*@Autowired
	private ClerckRepository repository;*/
	@Autowired
	public ClerkData components;
	@Autowired
	public ClerckRepository repository;
	@Autowired
	public DepartmentRepository DepartmenRepositoty;
	
	public ClerkDto save(ClerkSave data) {
		ClerkDto dto = null; 
		Optional<Department> department = DepartmenRepositoty.findAllById(data.getDepartment());
		if(department.isPresent()) {
			Clerk clerkToEntity = components.clerkData(data,department.get());
			Clerk save = repository.save(clerkToEntity);
			DepartmentDto departmentDto = new DepartmentDto(save.getDepartment());
			dto = new ClerkDto(save,departmentDto);
		}else {
			throw new BusinessExceptio("This dapartment not exist");
		}
		
		return dto;
	}
	
	public List<ClerkDto> getAll() {
		List<Clerk> clerks =  repository.findAll();
		List<ClerkDto> list = components.clerksDto(clerks);
		return list;
	}

	public ClerkDto getDocument(String data) {
		//System.out.print(data);
		/*ClerkDto dto = null; 
		Optional<Clerk> fingDocument = repository.findByCpf(data.getDocument());
		//String document = components.findDocument(data.getDocument());
		if(fingDocument.isPresent()) {
			throw new BusinessExceptio("ok");
			//DepartmentDto departmentDto = new DepartmentDto(fingDocument.get().getDepartment());
			//dto = new ClerkDto(fingDocument.get(),departmentDto);
		}else {
			throw new BusinessExceptio("This clerck not exist");
		}*/
		return null;
	}


	
	
	

	
	
	

}
