package com.DoctorAppointment.Doctor.Controller;

import com.DoctorAppointment.Doctor.PlayLoad.DoctorDto;
import com.DoctorAppointment.Doctor.Repository.DoctorRepository;
import com.DoctorAppointment.Doctor.Service.DoctorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    //http://localhost:8080/doctor/save

    @PostMapping("/save")
    public ResponseEntity<DoctorDto>saveDoctor(@RequestBody DoctorDto doctorDto)
    {
        return new ResponseEntity<>(doctorService.saveDoctor(doctorDto), HttpStatus.CREATED);
    }

   // http://localhost:8080/doctor/getAll

    @GetMapping("/getAll")
    public ResponseEntity<List<DoctorDto>>getAllDoctor()
    {
        return new ResponseEntity<>(doctorService.getAllDoctor(),HttpStatus.OK);
    }

    // http://localhost:8080/doctor/get/docId


    @GetMapping("/get/{docId}")
    public ResponseEntity<DoctorDto>getDoctor(@PathVariable String docId)
    {
        return new ResponseEntity<>(doctorService.getDoctorDetails(docId),HttpStatus.OK);
    }

    // http://localhost:8080/doctor/delete/docId

    @DeleteMapping("/delete/{docId}")
    public ResponseEntity<?>deleteDoctor(@PathVariable String docId)
    {
       doctorService.deleteDoctorById(docId);
       return new ResponseEntity<>("doctor detail is deleted successfully !",HttpStatus.OK);
    }


    @PutMapping("/updateFee")
    public ResponseEntity<DoctorDto>updateFee(@RequestParam String docId,@RequestParam long fee )
    {
        DoctorDto doctorDto = doctorService.updateFee(docId,fee);
        return new ResponseEntity<>(doctorDto,HttpStatus.OK);
    }
}
