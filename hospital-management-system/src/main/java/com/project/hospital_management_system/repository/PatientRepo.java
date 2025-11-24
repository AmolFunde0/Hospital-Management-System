package com.project.hospital_management_system.repository;

import com.project.hospital_management_system.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    // You can add custom query methods here if needed, for example:
    // List<Patient> findByNameContainingIgnoreCase(String name);
}
