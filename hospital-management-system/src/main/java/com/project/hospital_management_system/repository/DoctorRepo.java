package com.project.hospital_management_system.repository;

import com.project.hospital_management_system.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {
    // Add custom query methods if needed, e.g.:
    // List<Doctor> findBySpecialityContainingIgnoreCase(String speciality);
}
