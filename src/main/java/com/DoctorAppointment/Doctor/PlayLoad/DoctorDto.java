package com.DoctorAppointment.Doctor.PlayLoad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private String docId;
    private String name;
    private String specialization;
    private long fees;
}
