package com.system.ophtalmological.System.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.system.ophtalmological.System.entity.Report;
@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{

	Report findByName(String name);

	//@Query("SELECT r.name FROM report as r WHERE r.name = :name")
	//Report findByName(String name);
	//String findReportByName(String name); 
	
}
