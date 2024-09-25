package com.DoctorAppointment.Doctor.Service.ServiceImpl;

import com.DoctorAppointment.Doctor.Entity.Slots;
import com.DoctorAppointment.Doctor.Repository.SlotsRepository;
import com.DoctorAppointment.Doctor.Service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotsServiceImpl implements SlotsService {
    @Autowired
    private SlotsRepository slotsRepository;
    @Override
    public Slots saveSlots(Slots slots) {
        return slotsRepository.save(slots);
    }

    @Override
    public List<Slots> getAllSlots() {
        return slotsRepository.findAll();
    }

    @Override
    public Slots getSlots(long slotId) {
        return slotsRepository.findById(slotId).get();
    }

    @Override
    public void deleteSlot(long slotId) {
       slotsRepository.deleteById(slotId);
    }
}
