package com.DoctorAppointment.Doctor.Entity;

import com.DoctorAppointment.Booking.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="doctor")
@ToString
public class Doctor {

    @Id
    private String docId;
    private String name;
    private String specialization;
    private long fees;
    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Booking>booking=new ArrayList<>();
}
