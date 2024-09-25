package com.DoctorAppointment.Booking.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private String doctorId;
    private String city;
    private LocalDate date;
    private long slotId;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private long age;


}
