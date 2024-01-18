package com.system.ophtalmological.System.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Doctor;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	Optional<Doctor> findByCpf (String cpf);

}
