package com.DoctorAppointment.Doctor.Service.ServiceImpl;

import com.DoctorAppointment.Doctor.Entity.Doctor;
import com.DoctorAppointment.Doctor.PlayLoad.DoctorDto;
import com.DoctorAppointment.Doctor.Repository.DoctorRepository;
import com.DoctorAppointment.Doctor.Service.DoctorService;
import com.DoctorAppointment.Exception.ResourceNotFound;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository docRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public DoctorDto mapToDto(Doctor doctor) {
        return modelMapper.map(doctor,DoctorDto.class);
    }

    @Override
    public Doctor mapToEntity(DoctorDto dto) {
        return modelMapper.map(dto,Doctor.class);
    }

    @Override
    public DoctorDto saveDoctor(DoctorDto dto) {
        Doctor doctor = mapToEntity(dto);
        String id = UUID.randomUUID().toString();
        doctor.setDocId(id);
        return mapToDto(docRepo.save(doctor));
    }

    @Override
    public List<DoctorDto> getAllDoctor() {
        List<Doctor> all = docRepo.findAll();
        return all.stream().map(x->mapToDto(x)).collect(Collectors.toList());
    }

    @Override
    public DoctorDto getDoctorDetails(String docId) {

        return mapToDto(docRepo.findById(docId).get());
    }

    @Override
    public void deleteDoctorById(String docId) {
        docRepo.deleteById(docId);
    }

    @Override
    public DoctorDto updateFee(String docId, long fee) {
        Doctor doctor = docRepo.findById(docId).orElseThrow(() -> new ResourceNotFound("data not found !"));
        doctor.setFees(fee);
        Doctor save = docRepo.save(doctor);
        return mapToDto(save);
    }
}
