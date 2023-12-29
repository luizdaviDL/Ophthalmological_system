package com.system.ophtalmological.System.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.clerk.ClerkData;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.clerk.ClerkSave;
import com.system.ophtalmological.System.entity.Clerk;

@Service
public class ClerkService {
	/*@Autowired
	private ClerckRepository repository;*/
	@Autowired
	public ClerkData components;

	public ClerkDto save(ClerkSave data) {
		System.out.print("dados" + data);
		Clerk clerkToEntity = components.clerkData(data);
		System.out.print(clerkToEntity);
		//Optional<Clerk> document = repository.getByDocument(clerkToEntity);
		
		return null;
	}

}
