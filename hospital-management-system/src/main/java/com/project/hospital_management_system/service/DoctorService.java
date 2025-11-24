package com.project.hospital_management_system.service;

import com.project.hospital_management_system.models.Doctor;
import com.project.hospital_management_system.repository.DoctorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    public List<Doctor> getAllDoctors() {
        try {
            return doctorRepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all doctors: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        try {
            return doctorRepo.save(doctor);
        } catch (Exception e) {
            logger.error("Error occurred while adding new doctor: {}", e.getMessage());
            return null;
        }
    }

    public Doctor getDoctorById(Long id) {
        try {
            return doctorRepo.findById(id).orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching doctor by ID {}: {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteDoctor(Long id) {
        try {
            if (doctorRepo.existsById(id)) {
                doctorRepo.deleteById(id);
                logger.info("Doctor with ID {} deleted successfully", id);
            } else {
                logger.warn("Doctor with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting doctor {}: {}", id, e.getMessage());
        }
    }

    public void updateDoctor(Long id, Doctor doctor) {
        try {
            Optional<Doctor> existingDoctor = doctorRepo.findById(id);
            if (existingDoctor.isPresent()) {
                Doctor doctor1 = existingDoctor.get();
                doctor1.setName(doctor.getName());
                doctor1.setSpeciality(doctor.getSpeciality());
                doctor1.setAge(doctor.getAge());

                doctorRepo.save(doctor1);
                logger.info("Doctor with ID {} updated successfully", id);
            } else {
                logger.warn("Doctor with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Unable to update doctor {}: {}", id, e.getMessage());
        }
    }
}
