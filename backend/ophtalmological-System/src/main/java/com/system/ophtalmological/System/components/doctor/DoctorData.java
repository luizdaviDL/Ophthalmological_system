package com.system.ophtalmological.System.components.doctor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.system.ophtalmological.System.components.BusinessExceptio;
import com.system.ophtalmological.System.entity.Appointment;
import com.system.ophtalmological.System.entity.Department;
import com.system.ophtalmological.System.entity.Doctor;
import com.system.ophtalmological.System.repository.AppointmentRepository;
import com.system.ophtalmological.System.repository.DoctorRepository;

@Component
public class DoctorData {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private DoctorRepository repository;
	
	public Doctor toEntity(DoctorToEntity dataDoctor, Department department,List<Appointment> appointment) {		
		//System.out.println("AQUI: "+ data.getCpf() + " DEPARTMENT: "+department.getName()+ " APPOINTMENT: " + appointment.get(0).getName());
		Doctor result = new Doctor();
		try {
			result = mapper.map(dataDoctor, Doctor.class);
			//result.setDepartment(department);
			//result.setEspeciality(appointment);
			System.out.println("RESULT:" );
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return result;
	}
	
	public List<Appointment> getAppointments(List<Long> data) {
		List<Appointment> list = new ArrayList<>();
		try {			
			data.stream().forEach(i ->{
				Optional<Appointment> appointment = appointmentRepository.findById(i);
				if(appointment.isPresent()) {					
					list.add(appointment.get());
				}else {
					throw new BusinessExceptio("Same department not exist");
				}
			});
		}catch(Exception e) {
			System.out.print(e);
		}
		return list;
	}
	
	public List<Appointment> getAppointmentList(List<Appointment> dataList) {
		List<Appointment> list = new ArrayList<>();
		try {			
			dataList.stream().forEach(i ->{
				Optional<Appointment> appointment = appointmentRepository.findById(i.getId());
				if(appointment.isPresent()) {					
					list.add(appointment.get());
				}else {
					throw new BusinessExceptio("Same department not exist");
				}
			});
		}catch(Exception e) {
			System.out.print(e);
		}
		return list;
	}
	
	public List<Doctor> getDoctors(List<Doctor> data){
		List<Doctor> result = new ArrayList<>();
		data.stream().forEach(i->{
			Optional<Doctor> findDoctor = repository.findByCpf(i.getCpf());
			if(findDoctor.isPresent()) {
				result.add(findDoctor.get());
			}
		});
		return result;
	}
	
	
}
