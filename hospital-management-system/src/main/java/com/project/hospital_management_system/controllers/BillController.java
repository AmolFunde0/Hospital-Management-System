package com.project.hospital_management_system.controllers;

import com.project.hospital_management_system.models.Bill;
import com.project.hospital_management_system.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
@CrossOrigin(origins = "http://localhost:5173")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("Getting All Bills");
        return billService.getAllBills();
    }

    @PostMapping("/bill")
    public Bill generateBill(@RequestBody Bill bill) {
        System.out.println("New Bill Generated");
        return billService.createBill(bill);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable Long id) {
        System.out.println("Fetch Bill ById..");
        Bill bill = billService.getBillById(id);
        if (bill != null) {
            return ResponseEntity.ok(bill);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        System.out.println("The Bill is updated...");
        billService.updateBill(id, bill);
        return ResponseEntity.ok("Bill updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBill(@PathVariable Long id) {
        System.out.println("Bill is deleted..");
        billService.deleteBill(id);
        return ResponseEntity.ok("Bill deleted successfully");
    }
}
