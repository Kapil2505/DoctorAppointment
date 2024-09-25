package com.DoctorAppointment.Doctor.Service;

import com.DoctorAppointment.Doctor.Entity.Slots;

import java.util.List;

public interface SlotsService {
    Slots saveSlots(Slots slots);
    List<Slots>getAllSlots();
    Slots getSlots(long slotId);
    void deleteSlot(long slotId);
}
