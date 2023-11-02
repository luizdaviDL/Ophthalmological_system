package com.system.ophtalmological.System.modalMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalMapperCon {
	@Bean
	ModelMapper  modalMapper() {
		return new ModelMapper();
	}
}
