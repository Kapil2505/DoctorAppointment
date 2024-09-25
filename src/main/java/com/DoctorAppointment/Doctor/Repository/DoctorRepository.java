package com.DoctorAppointment.Doctor.Repository;

import com.DoctorAppointment.Doctor.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,String> {
    List<Doctor> findBySpecialization(String specialization);
}
