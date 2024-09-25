package com.DoctorAppointment.Doctor.Service;

import com.DoctorAppointment.Doctor.Entity.Doctor;
import com.DoctorAppointment.Doctor.PlayLoad.DoctorDto;

import java.util.List;

public interface DoctorService {

    DoctorDto mapToDto(Doctor doctor);
    Doctor mapToEntity(DoctorDto dto);

    DoctorDto saveDoctor(DoctorDto dto);
    List<DoctorDto>getAllDoctor();
    DoctorDto getDoctorDetails(String docId);

    void deleteDoctorById(String docId);

    DoctorDto updateFee(String docId, long fee);
}
