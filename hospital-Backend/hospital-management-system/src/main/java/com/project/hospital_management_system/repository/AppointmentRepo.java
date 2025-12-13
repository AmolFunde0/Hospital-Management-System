package com.project.hospital_management_system.repository;

import com.project.hospital_management_system.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    // Example: Add custom finder methods later if needed
    // List<Appointment> findByDoctorId(Long doctorId);
    // List<Appointment> findByPatientId(Long patientId);
}
