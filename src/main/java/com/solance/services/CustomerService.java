package com.solance.services;

import com.solance.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerService {

    // HashMap acts as in-memory repository
    private final Map<String, CustomerEntity> customerMap = new HashMap<>();

    // Add a customer entry
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        // Generate ID if not present (you can customize ID generation)
        if (customer.getId() == null || customer.getId().isEmpty()) {
            customer.setId(UUID.randomUUID().toString());
        }
        customerMap.put(customer.getId(), customer);
        return customer;
    }

    // Get customer by ID
    public Optional<CustomerEntity> getCustomerById(String id) {
        return Optional.ofNullable(customerMap.get(id));
    }

    // Get all customers
    public List<CustomerEntity> getAllCustomers() {
        return new ArrayList<>(customerMap.values());
    }

    // Update customer entry
    public CustomerEntity updateCustomer(String id, CustomerEntity updatedCustomer) {
        if (!customerMap.containsKey(id)) {
            throw new NoSuchElementException("Customer with ID " + id + " not found");
        }
        // Ensure the ID is set to path variable id
        updatedCustomer.setId(id);
        customerMap.put(id, updatedCustomer);
        return updatedCustomer;
    }

    // Delete customer by ID
    public boolean deleteCustomer(String id) {
        return customerMap.remove(id) != null;
    }

    // Bulk create customers
    public String createAllCustomers(List<CustomerEntity> customers) {
        for (CustomerEntity customer : customers) {
            if (customer.getId() == null || customer.getId().isEmpty()) {
                customer.setId(UUID.randomUUID().toString());
            }
            customerMap.put(customer.getId(), customer);
        }
        return "Customers added successfully";
    }
}
