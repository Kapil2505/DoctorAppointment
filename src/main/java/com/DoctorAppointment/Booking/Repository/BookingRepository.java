package com.DoctorAppointment.Booking.Repository;

import com.DoctorAppointment.Booking.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,String> {
    List<Booking>findByDate(LocalDate date);
}
