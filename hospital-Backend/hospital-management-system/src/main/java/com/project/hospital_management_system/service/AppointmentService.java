package com.project.hospital_management_system.service;

import com.project.hospital_management_system.models.Appointment;
import com.project.hospital_management_system.repository.AppointmentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;

    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    public List<Appointment> getAllAppointments() {
        try {
            return appointmentRepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all appointments: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public Appointment createAppointment(Appointment appointment) {
        try {
            return appointmentRepo.save(appointment);
        } catch (Exception e) {
            logger.error("Error occurred while creating new appointment: {}", e.getMessage());
            return null;
        }
    }

    public Appointment getAppointmentById(Long id) {
        try {
            return appointmentRepo.findById(id).orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching appointment by ID {}: {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteAppointment(Long id) {
        try {
            if (appointmentRepo.existsById(id)) {
                appointmentRepo.deleteById(id);
                logger.info("Appointment with ID {} deleted successfully", id);
            } else {
                logger.warn("Appointment with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting appointment {}: {}", id, e.getMessage());
        }
    }

    public void updateAppointment(Long id, Appointment updatedAppointment) {
        try {
            Optional<Appointment> existingAppointment = appointmentRepo.findById(id);
            if (existingAppointment.isPresent()) {
                Appointment appointment = existingAppointment.get();
                appointment.setPatientId(updatedAppointment.getPatientId());
                appointment.setDoctorId(updatedAppointment.getDoctorId());
                appointment.setDate(updatedAppointment.getDate());

                appointmentRepo.save(appointment);
                logger.info("Appointment with ID {} updated successfully", id);
            } else {
                logger.warn("Appointment with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Unable to update appointment {}: {}", id, e.getMessage());
        }
    }
}
