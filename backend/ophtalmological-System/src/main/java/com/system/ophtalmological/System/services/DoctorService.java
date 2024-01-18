package com.system.ophtalmological.System.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.components.appointment.AppointmentData;
import com.system.ophtalmological.System.components.appointment.AppointmentDto;
import com.system.ophtalmological.System.components.appointment.DoctorDto;
import com.system.ophtalmological.System.components.doctor.DoctorData;
import com.system.ophtalmological.System.components.doctor.DoctorSave;
import com.system.ophtalmological.System.components.doctor.DoctorToEntity;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.entity.Doctor;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.DepartmentRepository;
import com.system.ophtalmological.System.repository.DoctorRepository;
@Service
public class DoctorService {
	@Autowired
	private DoctorRepository repository;
	@Autowired
	private DoctorData dataClass;
	@Autowired
	private DepartmentRepository departmentRepository; //
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private AppointmentData appointmentData;
	

	public DoctorDto save(DoctorSave data) {
		DoctorDto dto = null;
		Appointment apoint = new Appointment();
		Optional<Doctor> doctor = repository.findByCpf(data.getCpf());
		Optional<Department> findDepartment = departmentRepository.findById(data.getDepartment());
		if(doctor.isEmpty() && findDepartment.isPresent()) {
			try {				
				List<Appointment> appointments = dataClass.getAppointments(data.getEspeciality());
				DoctorToEntity dataDoctor = new DoctorToEntity(data,findDepartment.get(), appointments);
				Doctor doctorEntity = dataClass.toEntity(dataDoctor,findDepartment.get(),appointments);
				Doctor save = repository.save(doctorEntity);
				apoint.getDoctors().add(save);
				List<AppointmentDto> appointmentList = appointmentData.getAll(save.getEspeciality());
				dto = new DoctorDto(doctorEntity,appointmentList);
			}catch(Exception e) {
				System.out.print(e);
			}
			
		}else {
			throw new BusinessExceptio("Doctor already exist");
		}
		return dto ;
	}

}
