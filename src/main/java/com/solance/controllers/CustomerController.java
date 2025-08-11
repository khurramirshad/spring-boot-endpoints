package com.solance.controllers;

import com.solance.entities.CustomerEntity;
import com.solance.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) {
        try {
            CustomerEntity savedCustomer = customerService.saveCustomer(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers() {
        List<CustomerEntity> customers = customerService.getAllCustomers();
        if (!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/Id/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable String id) {
        Optional<CustomerEntity> customer = customerService.getCustomerById(id);
        if (customer.isPresent()) {
            return new ResponseEntity<>(customer.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer not found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/Id/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable String id, @RequestBody CustomerEntity customer) {
        try {
            CustomerEntity updated = customerService.updateCustomer(id, customer);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to update customer");
        }
    }

    @DeleteMapping("/Id/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id) {
        if (customerService.deleteCustomer(id)) {
            return ResponseEntity.ok("Successfully deleted customer");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }
}
