package com.DoctorAppointment.Booking.Service;

import com.DoctorAppointment.Booking.Entity.Booking;
import com.DoctorAppointment.Booking.PayLoad.BookingDto;
import com.DoctorAppointment.Booking.PayLoad.BookingResponse;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {
    Booking bookAppointment(BookingDto bookingDto);

    BookingResponse getAllBookings(int pageNo, int pageSize , String sortBy, String sortDir);

    Booking getBooking(String bookingId);

    List<Booking>getByDate(LocalDate date);
}
