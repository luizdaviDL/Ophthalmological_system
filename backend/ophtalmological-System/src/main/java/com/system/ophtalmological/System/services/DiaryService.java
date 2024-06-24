package com.system.ophtalmological.System.services;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.Department.DepartmentDto;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.clerk.ClerkDto;
import com.system.ophtalmological.System.components.diary.DiaryDto;
import com.system.ophtalmological.System.components.diary.DiarySave;
import com.system.ophtalmological.System.components.patients.PatientDto;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Clerk;
import com.system.ophtalmological.System.entity.Diary;
import com.system.ophtalmological.System.entity.Patient;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.ClerckRepository;
import com.system.ophtalmological.System.repository.DiaryRepository;
import com.system.ophtalmological.System.repository.PatientRepository;
@Service
public class DiaryService {
	@Autowired
	private DiaryRepository repository;
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ClerckRepository clerckRepository;
	

	public DiaryDto save(DiarySave data) throws ParseException {		
		Long patient = repository.getpatient(data.getPatient());
		Optional<Patient> entityPatient = patientRepository.findById(data.getPatient());
		Optional<Appointment> appointment = appointmentRepository.findById(data.getAppointment());
		Optional<Clerk> clerk = clerckRepository.findById(data.getDoctor());
		DiaryDto dto = null;
		
		if(data.getId() ==null) {
			if(patient==null && entityPatient.isPresent() && appointment.isPresent() && clerk.isPresent()) {				
				Diary result= saveDiary(null,entityPatient.get(),appointment.get(),clerk.get(),data.getDate(), data.getTime());
				dto = savingDto(result.getId(),  result.getPatient(),result.getAppointment(),result.getDoctor(),result.getDate(),result.getTime());				
			}else if(patient!=null){
				throw new BusinessExceptio("Pacient already have diary");
			}else {
				throw new BusinessExceptio("Erro scheduling data");
			}
			
		
		}else {
			Optional<Diary> findiary = repository.findById(data.getId());
			if(findiary.isPresent()) {
				if(patient!=null && entityPatient.isPresent() && appointment.isPresent() && clerk.isPresent()) {					
					Diary result= saveDiary(data.getId(),entityPatient.get(),appointment.get(),clerk.get(),data.getDate(), data.getTime());
					dto = savingDto(result.getId(),  result.getPatient(),result.getAppointment(),result.getDoctor(),result.getDate(),result.getTime());			
				}else {
					throw new BusinessExceptio("Erro ao alterar oss dados");
				}
			}
		}
		return dto;
	}
	
	private Diary saveDiary(Long id,Patient entityPatient, Appointment appointment, Clerk clerk, Date date, LocalTime time) {
		Diary saving =null;
		if(id ==null) {
        	Diary instance = new Diary(entityPatient, appointment, clerk, date, time);
        	saving = repository.save(instance);
        }
		Diary instance = new Diary(id,entityPatient, appointment, clerk, date, time);
    	saving = repository.save(instance);
        
        return saving;
    }
	
	private DiaryDto savingDto(Long id, Patient pa, Appointment appoint, Clerk doctor, Date date, LocalTime time) {
		PatientDto patient =new PatientDto(pa);
		AppointmentDto appointment = new AppointmentDto(appoint);
		ClerkDto clerck = new ClerkDto(doctor);
		DiaryDto dto = new DiaryDto(id,patient, appointment,clerck,date,time);
		return dto;
	}

	public List<DiaryDto> delete(DiarySave data) {
		Optional<Diary> findiary = repository.findById(data.getId());
		if(findiary.isPresent()) {
			 repository.deleteById(data.getId());				 
		}		
		return getAll();		
	}
	
	public List<DiaryDto> getAll() {
		List<DiaryDto> dto = new ArrayList<>();
		
		List<Diary> allDiary = repository.findAll();
		
		allDiary.stream().forEach(i->{		
			PatientDto patient =new PatientDto(i.getPatient());
			AppointmentDto appointment = new AppointmentDto(i.getAppointment());
			DepartmentDto department = new DepartmentDto(i.getDoctor().getDepartment());
			ClerkDto clerck = new ClerkDto(i.getDoctor(),department);
			
			DiaryDto instance = new DiaryDto(i.getId(),patient,appointment,clerck, i.getDate(), i.getTime());
			dto.add(instance);
		});
		return dto;
	}
	
}
