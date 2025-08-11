package com.solance.controllers;

import com.solance.entities.PaymentEntity;
import com.solance.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentInstructionController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping
    public ResponseEntity<PaymentEntity> addPaymentInstruction(@RequestBody PaymentEntity payment) {

        try {
            PaymentEntity savedPayment = paymentService.savePayment(payment);
            return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<?> getAllPaymentInstruction() {
        List<PaymentEntity> allPayments = paymentService.getAllPayments();
        if (!allPayments.isEmpty()) {
            return new ResponseEntity<>(allPayments, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping("/Id/{id}")
    public ResponseEntity<?> getPaymentInstructionById(@PathVariable String id) {
        Optional<PaymentEntity> paymentEntity = paymentService.getPaymentInstructionByID(id);
        if (paymentEntity.isPresent()) {
            return new ResponseEntity<>(paymentEntity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Payment instruction not found", HttpStatus.NOT_FOUND);
    }


    @PutMapping("/Id/{id}")
    public ResponseEntity<?> updatePaymentInstruction(@PathVariable String id, @RequestBody PaymentEntity payment) {
        try {
            PaymentEntity updated = paymentService.updatePaymentInstruction(id, payment);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update payment instruction");
        }
    }


    @DeleteMapping("/Id/{id}")
    public ResponseEntity<?> deletePaymentInstruction(@PathVariable String id) {
        if (paymentService.deletePaymentInstruction(id)) {
            return ResponseEntity.ok("Successfully deleted payment instruction");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Payment instruction not found");
        }
    }


}
