package com.system.ophtalmological.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Clerk;

@Repository
public interface ClerckRepository extends JpaRepository<Clerk, Long>{

	

	

	 
	
	//Clerk getByDocument(String cpf);

}
