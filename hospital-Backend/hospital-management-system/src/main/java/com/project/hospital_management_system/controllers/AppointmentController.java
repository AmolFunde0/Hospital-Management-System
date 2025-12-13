package com.project.hospital_management_system.controllers;

import com.project.hospital_management_system.models.Appointment;
import com.project.hospital_management_system.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/v1/appointment")
@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointment() {
        logger.info("Fetching all appointments...");
        List<Appointment> appointments = appointmentService.getAllAppointments();

        if (appointments.isEmpty()) {
            logger.warn("No appointments found in the system.");
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        }

        logger.info("Found {} appointments.", appointments.size());
        return ResponseEntity.ok(appointments);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> createNewAappointment(@RequestBody Appointment appointment) {
        logger.info("Creating new appointment for patient ID: {} and doctor ID: {}",
                appointment.getPatientId(), appointment.getDoctorId());
        Appointment savedAppointment = appointmentService.createAppointment(appointment);

        if (savedAppointment == null) {
            logger.error("Failed to create appointment. Invalid data provided.");
            return ResponseEntity.badRequest().build(); // HTTP 400 Bad Request
        }

        logger.info("New appointment created successfully with ID: {}", savedAppointment.getId());
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        logger.info("Fetching appointment with ID: {}", id);
        Appointment appointment = appointmentService.getAppointmentById(id);

        if (appointment != null) {
            logger.info("Appointment found with ID: {}", id);
            return ResponseEntity.ok(appointment);
        } else {
            logger.warn("Appointment not found for ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAppointment(@PathVariable Long id, @RequestBody Appointment appointment) {
        logger.info("Attempting to update appointment with ID: {}", id);

        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment == null) {
            logger.warn("Cannot update — appointment with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }

        appointmentService.updateAppointment(id, appointment);
        logger.info("Appointment with ID {} updated successfully.", id);
        return ResponseEntity.ok("Appointment updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable Long id) {
        logger.info("Attempting to delete appointment with ID: {}", id);

        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        if (existingAppointment == null) {
            logger.warn("Cannot delete — appointment with ID {} not found.", id);
            return ResponseEntity.notFound().build();
        }

        appointmentService.deleteAppointment(id);
        logger.info("Appointment with ID {} deleted successfully.", id);
        return ResponseEntity.ok("Appointment deleted successfully");
    }
}
