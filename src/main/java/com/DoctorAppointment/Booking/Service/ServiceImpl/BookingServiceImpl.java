package com.DoctorAppointment.Booking.Service.ServiceImpl;

import com.DoctorAppointment.Booking.Entity.Booking;
import com.DoctorAppointment.Booking.PayLoad.BookingDto;
import com.DoctorAppointment.Booking.PayLoad.BookingResponse;
import com.DoctorAppointment.Booking.Repository.BookingRepository;
import com.DoctorAppointment.Booking.Service.BookingService;
import com.DoctorAppointment.Doctor.Entity.Doctor;
import com.DoctorAppointment.Doctor.Entity.Slots;
import com.DoctorAppointment.Doctor.Repository.DoctorRepository;
import com.DoctorAppointment.Doctor.Repository.SlotsRepository;
import com.DoctorAppointment.Exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SlotsRepository slotsRepository;
    @Override
    public Booking bookAppointment(BookingDto bookingDto) {
        Booking booking = new Booking();
        String bookingId = UUID.randomUUID().toString();
        booking.setBookingId(bookingId);
        Doctor doctor = doctorRepository.findById(bookingDto.getDoctorId()).orElseThrow(() -> new ResourceNotFound("Doctor not found"));
        booking.setDoctor(doctor);
        booking.setDate(bookingDto.getDate());
        Slots slot = slotsRepository.findById(bookingDto.getSlotId()).orElseThrow(() -> new ResourceNotFound("slot are found"));
        booking.setSlots(slot);
        booking.setCity(bookingDto.getCity());
        booking.setFirstName(bookingDto.getFirstName());
        booking.setLastName(bookingDto.getLastName());
        booking.setEmail(bookingDto.getEmail());
        booking.setMobileNumber(bookingDto.getMobileNumber());
        booking.setAge(bookingDto.getAge());

        return bookingRepository.save(booking);
    }

    @Override
    public BookingResponse getAllBookings(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
       Pageable pageable =  PageRequest.of(pageNo,pageSize,sort);
        Page<Booking> pageObject = bookingRepository.findAll(pageable);
        List<Booking> content = pageObject.getContent();
        BookingResponse response = new BookingResponse();
        response.setList(content);
        response.setPageNo(pageObject.getNumber());
        response.setPageSize(pageObject.getSize());
        response.setLastPage(pageObject.isLast());
        response.setTotalPage(pageObject.getTotalPages());
        response.setList(content);
        return response;
    }

    @Override
    public Booking getBooking(String bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new ResourceNotFound("booking is not found"));
        return booking;
    }

    @Override
    public List<Booking> getByDate(LocalDate date) {
        return bookingRepository.findByDate(date);
    }
}
