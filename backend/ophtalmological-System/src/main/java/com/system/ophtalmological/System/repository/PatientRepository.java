package com.system.ophtalmological.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{
	//increase this function in the interface and that function will get funtionalitys sql 
	Optional<Patient> findByCpf(String cpfN);
}
