package com.DoctorAppointment.Booking.PayLoad;

import com.DoctorAppointment.Booking.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    private List<Booking> list = new ArrayList<>();
    private long pageNo;
    private long pageSize;
    private long totalPage;
    private boolean isLastPage;
}
