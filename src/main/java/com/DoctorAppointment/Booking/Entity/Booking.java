package com.DoctorAppointment.Booking.Entity;

import com.DoctorAppointment.Doctor.Entity.Doctor;
import com.DoctorAppointment.Doctor.Entity.Slots;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="booking")
public class Booking {
    @Id
    private String bookingId;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="doctorId")
    private Doctor doctor;
    private String city;
    private LocalDate date;
    @OneToOne
    private Slots slots;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private long age;


}
