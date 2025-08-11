package com.solance.controllers;

import com.solance.entities.DepositeEntity;
import com.solance.services.DepositeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/deposit")
public class DepositTransactionController {

    @Autowired
    private DepositeService transactionService;

    @PostMapping
    public ResponseEntity<DepositeEntity> addTransaction(@RequestBody DepositeEntity transaction) {
        try {
            DepositeEntity saved = transactionService.saveTransaction(transaction);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactions() {
        List<DepositeEntity> transactions = transactionService.getAllTransactions();
        if (!transactions.isEmpty()) {
            return new ResponseEntity<>(transactions, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<?> getTransactionById(@PathVariable String id) {
        Optional<DepositeEntity> transaction = transactionService.getTransactionById(id);
        if (transaction.isPresent()) {
            return new ResponseEntity<>(transaction.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Transaction not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/Id/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable String id, @RequestBody DepositeEntity transaction) {
        try {
            DepositeEntity updated = transactionService.updateTransaction(id, transaction);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update transaction");
        }
    }

    @DeleteMapping("/Id/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable String id) {
        if (transactionService.deleteTransaction(id)) {
            return ResponseEntity.ok("Successfully deleted transaction");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transaction not found");
        }
    }
}
