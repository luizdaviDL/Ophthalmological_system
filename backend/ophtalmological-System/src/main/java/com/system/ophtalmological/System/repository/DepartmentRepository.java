package com.system.ophtalmological.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Optional<Department> getByname(String name);

	Optional<Department> findByName(String name);

	Optional<Department> findAllById(Long department);

	List<Department> findByClerkId(Long clerkId);

}
