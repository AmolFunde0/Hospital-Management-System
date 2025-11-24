package com.project.hospital_management_system.service;

import com.project.hospital_management_system.models.Bill;
import com.project.hospital_management_system.repository.BillRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepo billRepo;

    private static final Logger logger = LoggerFactory.getLogger(BillService.class);

    public List<Bill> getAllBills() {
        try {
            return billRepo.findAll();
        } catch (Exception e) {
            logger.error("Error occurred while fetching all bills: {}", e.getMessage());
            return Collections.emptyList();
        }
    }

    public Bill createBill(Bill bill) {
        try {
            return billRepo.save(bill);
        } catch (Exception e) {
            logger.error("Error occurred while creating new bill: {}", e.getMessage());
            return null;
        }
    }

    public Bill getBillById(Long id) {
        try {
            return billRepo.findById(id).orElse(null);
        } catch (Exception e) {
            logger.error("Error occurred while fetching bill by ID {}: {}", id, e.getMessage());
            return null;
        }
    }

    public void deleteBill(Long id) {
        try {
            if (billRepo.existsById(id)) {
                billRepo.deleteById(id);
                logger.info("Bill with ID {} deleted successfully", id);
            } else {
                logger.warn("Bill with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Error occurred while deleting bill {}: {}", id, e.getMessage());
        }
    }

    public void updateBill(Long id, Bill updatedBill) {
        try {
            Optional<Bill> existingBill = billRepo.findById(id);
            if (existingBill.isPresent()) {
                Bill bill = existingBill.get();
                bill.setPatientId(updatedBill.getPatientId());
                bill.setAmount(updatedBill.getAmount());
                bill.setStatus(updatedBill.getStatus());

                billRepo.save(bill);
                logger.info("Bill with ID {} updated successfully", id);
            } else {
                logger.warn("Bill with ID {} not found", id);
            }
        } catch (Exception e) {
            logger.error("Unable to update bill {}: {}", id, e.getMessage());
        }
    }
}
