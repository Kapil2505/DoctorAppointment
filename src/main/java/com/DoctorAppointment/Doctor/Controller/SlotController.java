package com.DoctorAppointment.Doctor.Controller;

import com.DoctorAppointment.Doctor.Entity.Slots;
import com.DoctorAppointment.Doctor.Service.SlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slot")
public class SlotController {
    @Autowired
    private SlotsService slotsService;

    //http://localhost:8080/slot/save
    @PostMapping("/save")
    public ResponseEntity<Slots>saveSlots(@RequestBody Slots slots)
    {
        return new ResponseEntity<>(slotsService.saveSlots(slots), HttpStatus.CREATED);
    }

    //http://localhost:8080/slot/getAll
    @GetMapping("/getAll")
    public ResponseEntity<List<Slots>>getAllSlots()
    {
        return new ResponseEntity<>(slotsService.getAllSlots(),HttpStatus.OK);
    }

    //http://localhost:8080/slot/getSlot/slotId
    @GetMapping("/getSlot/{slotId}")
    public ResponseEntity<Slots>getSlot(@PathVariable Long slotId)
    {
        return new ResponseEntity<>(slotsService.getSlots(slotId),HttpStatus.OK);
    }

    //http://localhost:8080/slot/delete/slotId
    @DeleteMapping("/delete/{slotId}")
    public ResponseEntity<?>deleteSlot(@PathVariable Long slotId)
    {
        slotsService.deleteSlot(slotId);
        return new ResponseEntity<>("slot is deleted successfully !",HttpStatus.OK);
    }
}
