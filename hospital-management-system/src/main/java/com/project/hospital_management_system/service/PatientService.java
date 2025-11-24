package com.project.hospital_management_system.service;

import com.project.hospital_management_system.models.Patient;
import com.project.hospital_management_system.repository.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo patientRepo;

    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    public List<Patient> getAllPatients() {
        try {
            return patientRepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all patients: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public Patient createPatient(Patient patient) {
        try {
            return patientRepo.save(patient);
        } catch (Exception e) {
            logger.error("Error occurred while adding new patient: {}", e.getMessage());
            return null;
        }
    }

    public Patient getPatientById(Long id) {
        try {
            return patientRepo.findById(id).orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching patient by ID {}: {}", id, e.getMessage());
            return null;
        }
    }

    public void deletePatient(Long id) {
        try {
            if (patientRepo.existsById(id)) {
                patientRepo.deleteById(id);
                logger.info("Patient with ID {} deleted successfully", id);
            } else {
                logger.warn("Patient with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting patient {}: {}", id, e.getMessage());
        }
    }

    public void updatePatient(Long id, Patient patient) {
        try {
            Optional<Patient> existingPatient = patientRepo.findById(id);
            if (existingPatient.isPresent()) {
                Patient patient1 = existingPatient.get();
                patient1.setName(patient.getName());
                patient1.setGender(patient.getGender());
                patient1.setAge(patient.getAge());

                patientRepo.save(patient1);
                logger.info("Patient with ID {} updated successfully", id);
            } else {
                logger.warn("Patient with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Unable to update patient {}: {}", id, e.getMessage());
        }
    }
}
