package com.DoctorAppointment.Booking.Controller;

import com.DoctorAppointment.Booking.Entity.Booking;
import com.DoctorAppointment.Booking.PayLoad.BookingDto;
import com.DoctorAppointment.Booking.PayLoad.BookingResponse;
import com.DoctorAppointment.Booking.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //http://localhost:8080/booking/save
    // This API is used to book appointment (it saves appointment details in database).
    @PostMapping("/save")
    public ResponseEntity<Booking>bookAppointment(@RequestBody BookingDto bookingDto)
    {
       Booking appointment = bookingService.bookAppointment(bookingDto);
        return new ResponseEntity<>(appointment, HttpStatus.CREATED);
    }

    //http://localhost:8080/booking/get/all
    // This API is used to fetch all the appointment data from the database.
    @GetMapping("/get/all")
    public ResponseEntity<BookingResponse> getAllBooking(@RequestParam(name="pageNo",defaultValue ="0",required = false )int pageNo,@RequestParam(name="pageSize",defaultValue = "5",required = false)int pageSize,@RequestParam(value = "sortBy",defaultValue = "busId",required = false)String sortBy,@RequestParam(value = "sortDir",defaultValue = "asc",required = false)String sortDir)
    {
        BookingResponse bookings = bookingService.getAllBookings(pageNo, pageSize, sortBy, sortDir);
        return new ResponseEntity<>(bookings,HttpStatus.OK);
    }

    //http://localhost:8080/booking/get/{bookingId}
    // This API is used to fetch particular appointment for particular appointment Id
    @GetMapping("/get/{bookingId}")
    public ResponseEntity<Booking>getBooking(@PathVariable String bookingId)
    {
        Booking booking = bookingService.getBooking(bookingId);
        return new ResponseEntity<>(booking,HttpStatus.OK);
    }

    //http://localhost:8080/booking/get/{date}
    // This API is used to fetch all the appointments of particular date.
    @GetMapping("/get/{date}")
     public ResponseEntity<List<Booking>>getByDate(@PathVariable LocalDate date)
     {
         List<Booking> bookings = bookingService.getByDate(date);
         return new ResponseEntity<>(bookings,HttpStatus.OK);
     }
}
