package com.system.ophtalmological.System.repository;

import java.util.List;

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
	@Query(value = "select patient_id from report_medical where patient_id = :id", nativeQuery = true)
	Long getPatient(long id);
	@Query(value = "select report_id from report_medical where patient_id = :id", nativeQuery = true)
	Long getReport(long id);
	@Query(value = "select doctor_id from report_medical where patient_id = :id", nativeQuery = true)
	Long getDoctor(long id);
	@Query(value = "select id from report_medical where patient_id  = :id", nativeQuery = true)
	List<Long> getMedicalReport(long id);
	@Query(value = "select id, report_id, patient_id, doctor_id from report_medical where patient_id = :id", nativeQuery = true)
	List<Object[]> selectDataPatient(long id);
	
	
}
