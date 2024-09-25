package com.DoctorAppointment.Doctor.Repository;

import com.DoctorAppointment.Doctor.Entity.Slots;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SlotsRepository extends JpaRepository<Slots,Long> {
    List<Slots> findByDate(LocalDate date);
}
