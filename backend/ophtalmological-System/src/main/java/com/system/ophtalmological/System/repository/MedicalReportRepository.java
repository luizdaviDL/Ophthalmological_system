package com.system.ophtalmological.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.MedicalReport;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.entity.Report;

public interface MedicalReportRepository extends JpaRepository<MedicalReport,Long>{
	@Modifying
    @Query(value = "select report_id from report_medical where report_id = :id", nativeQuery = true)
	MedicalReport selectdocument(long id);
}
