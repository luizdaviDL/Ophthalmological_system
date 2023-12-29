package com.system.ophtalmological.System.components.clerk;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.entity.Clerk;
@Component
public class ClerkData {
	
	@Autowired
	private ModelMapper mapper;
	
	public Clerk clerkData(ClerkSave data) {
		return mapper.map(data, Clerk.class);
	}

}
