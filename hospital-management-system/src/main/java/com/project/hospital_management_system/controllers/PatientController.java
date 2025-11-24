package com.project.hospital_management_system.controllers;

import com.project.hospital_management_system.models.Patient;
import com.project.hospital_management_system.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        System.out.println("Getting all patients...");
        return patientService.getAllPatients();
    }

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        System.out.println("Creating new patient...");
        return patientService.createPatient(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        System.out.println("Fetching patient by ID...");
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        System.out.println("Deleting patient...");
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        System.out.println("Updating patient...");
        patientService.updatePatient(id, patient);
        return ResponseEntity.ok("Patient updated successfully");
    }
}
