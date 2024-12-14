package com.system.ophtalmological.System.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.medicalReport.MedicalReportData;
import com.system.ophtalmological.System.components.medicalReport.MedicalReportDto;
import com.system.ophtalmological.System.components.medicalReport.saveMR;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.components.patients.SavePatientDto;
import com.system.ophtalmological.System.components.report.ReportDto;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.MedicalReport;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.entity.Report;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.MedicalReportRepository;
import com.system.ophtalmological.System.repository.PatientRepository;
import com.system.ophtalmological.System.repository.ReportRepository;

@Service
public class MedicalReportService {
	@Autowired
	private MedicalReportRepository medicalrepository;	
	@Autowired
	private MedicalReportData reportdata;
	@Autowired
	private ReportRepository reportrepository;
	@Autowired
	private PatientRepository patientrepository;
	@Autowired
	private ClerckRepository clerkrepository;

	//save and update
	public MedicalReportDto save(saveMR data) {
		MedicalReportDto dto=null; 
		MedicalReport savemr = null;
		
		try {
			if(data.getId() !=null) {
				Optional<MedicalReport> value = medicalrepository.findById(data.getId());
				if(value.isPresent()) {
					Optional<Report> report = reportrepository.findById(data.getIdReport());	
					Optional<Patient> patient = patientrepository.findById(data.getIdPatient());
					Optional<Clerk> clerck = clerkrepository.findById(data.getIdDoctor());
					
					if(report.isPresent() && patient.isPresent() && clerck.isPresent()) {
						if(data.getDocumentPdf() ==null) {
							savemr = reportdata.saving(report.get(),patient.get(),clerck.get(), data.getDocument());
						}
						savemr = reportdata.saving(report.get(),patient.get(),clerck.get(), data.getDocument(), data.getDocumentPdf());
						MedicalReport database = medicalrepository.save(savemr);
						DepartmentDto departmentDto = new DepartmentDto(clerck.get().getDepartment());
						
						ReportDto reportdto = new ReportDto(database.getReport());
						PatientDto patientdto = new PatientDto(database.getPatient());
						ClerkDto clerckdto = new ClerkDto(database.getDoctor(),departmentDto);
						dto = new MedicalReportDto(database.getId(), reportdto,patientdto,clerckdto);			
					}else {
						throw new BusinessExceptio("Erro in the process");
					}
					return dto;
				}
				
			}
			Optional<Report> report = reportrepository.findById(data.getIdReport());	
			Optional<Patient> patient = patientrepository.findById(data.getIdPatient());
			Optional<Clerk> clerck = clerkrepository.findById(data.getIdDoctor());
			
			if(report.isPresent() && patient.isPresent() && clerck.isPresent()) {
				
				savemr = reportdata.saving(report.get(),patient.get(),clerck.get(), data.getDocument(), data.getDocumentPdf());
				MedicalReport database = medicalrepository.save(savemr);
				DepartmentDto departmentDto = new DepartmentDto(clerck.get().getDepartment());
				
				ReportDto reportdto = new ReportDto(database.getReport());
				PatientDto patientdto = new PatientDto(database.getPatient());
				ClerkDto clerckdto = new ClerkDto(database.getDoctor(),departmentDto);
				dto = new MedicalReportDto(database.getId(), reportdto,patientdto,clerckdto);			
			}else {
				throw new BusinessExceptio("Erro in the process");
			}
		}catch (Exception e){
			return null;
		}
		return dto;
	}
	
	public List<MedicalReportDto> getAll() {
		 try {
			 List<MedicalReportDto> list=new ArrayList<>();
				
				List<MedicalReport> all = medicalrepository.findAll();
				all.stream().forEach(i ->{
					ReportDto reportdto = new ReportDto(i.getReport());
					PatientDto patientdto = new PatientDto(i.getPatient());
					
					DepartmentDto departmentDto = new DepartmentDto(i.getDoctor().getDepartment());
					ClerkDto clerckdto = new ClerkDto(i.getDoctor(),departmentDto);
					MedicalReportDto dto = new MedicalReportDto(i.getId(),reportdto,patientdto,clerckdto);	
					list.add(dto);
				});
				return list;
		 }catch (Exception e){
				return null;
		 	}
	}
	
	public boolean deleteDocument(saveMR id) {
		try {
			MedicalReport value = medicalrepository.selectdocument(id.getId());
			if(value != null) {
				value.setWrittenDocument(null);
				value.setDocumentPdf(null);
	
			}
			return true;
		}catch (Exception e){
			return false;
		}
	}
	
	public boolean delete(saveMR id) {
		try {
			Optional<MedicalReport> value = medicalrepository.findById(id.getId());
			if(value.isPresent()) {
				medicalrepository.delete(value.get());
			}
			return true;
		}catch (Exception e){
			return false;
		}
	}

	public List<MedicalReportDto> getByPatient(SavePatientDto data) {
		List<MedicalReportDto> list=new ArrayList<>();
		
		try {
			Optional<Patient> patient = patientrepository.findByCpf(data.getCpf());
			
			if(patient.isPresent()) {

				Long patientid = medicalrepository.getPatient(patient.get().getId());
				if(patientid!=0) {
					
					Long reportId = medicalrepository.getReport(patient.get().getId());
					Long doctorId = medicalrepository.getDoctor(patient.get().getId());
				
					if(reportId !=0 && doctorId !=0) {
						
						Optional<Report> report = reportrepository.findById(reportId);	
						Optional<Clerk> clerck = clerkrepository.findById(doctorId);
						List<Long> medicalReportId = medicalrepository.getMedicalReport(patient.get().getId());
						
						if(medicalReportId.size() >1) {
							
							List<Object[]> dataPatient = medicalrepository.selectDataPatient(patient.get().getId());
							dataPatient.forEach(i ->{
								Long idMedical = (Long) i[0];
								Long reportid = (Long) i[1];
								Long patientId = (Long) i[2];
								Long doctorid= (Long) i[3];
								
								Optional<Report> elementR = reportrepository.findById(reportid);
								Optional<Patient> elementP = patientrepository.findById(patientId);
								Optional<Clerk> elementC = clerkrepository.findById(doctorid);
								
								ReportDto reportdto = new ReportDto(elementR.get());
								PatientDto patientdto = new PatientDto(elementP.get());
								ClerkDto clerckdto = new ClerkDto(elementC.get());
								MedicalReportDto dto = new MedicalReportDto(idMedical,reportdto,patientdto,clerckdto);	
								list.add(dto);
							});
							
						}else {
							Long reposrtId = medicalReportId.get(0);
							ReportDto reportdto = new ReportDto(report.get());
							PatientDto patientdto = new PatientDto(patient.get());
							ClerkDto clerckdto = new ClerkDto(clerck.get());
							MedicalReportDto dto2 = new MedicalReportDto(reposrtId,reportdto,patientdto,clerckdto);
							list.add(dto2);
						}
											
					}else {
						throw new BusinessExceptio("Erro to find values");
					}
									
				}else {
					throw new BusinessExceptio("patient no exist");
				}
	
			}else {
				throw new BusinessExceptio("Patient not exist");
			}
			
		}catch (Exception e){
			System.out.print(e);
			return null;
		}
		return list;
	}
	
	
	
}
