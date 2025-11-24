package com.project.hospital_management_system.controllers;

import com.project.hospital_management_system.models.Doctor;
import com.project.hospital_management_system.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        System.out.println("Getting list Of all Doctors..");
        return doctorService.getAllDoctors();
    }

    @PostMapping("/doctor")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        System.out.println("Doctor Added Successfully");
        return doctorService.createDoctor(doctor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        System.out.println("Fetch Doctor ById..");
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        System.out.println("The Doctor is updated...");
        doctorService.updateDoctor(id, doctor);
        return ResponseEntity.ok("Doctor updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable Long id) {
        System.out.println("Doctor is deleted..");
        doctorService.deleteDoctor(id);
        return ResponseEntity.ok("Doctor deleted successfully");
    }
}
