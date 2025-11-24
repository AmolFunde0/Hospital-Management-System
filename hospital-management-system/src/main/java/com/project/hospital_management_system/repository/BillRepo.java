package com.project.hospital_management_system.repository;

import com.project.hospital_management_system.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {
    // Optional: Add custom queries later if needed
    // List<Bill> findByStatus(String status);
}
