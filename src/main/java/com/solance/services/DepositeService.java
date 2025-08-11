package com.solance.services;

import com.solance.entities.DepositeEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class DepositeService {

    private final Map<String, DepositeEntity> transactionMap = new HashMap<>();

    // Save transaction, generate ID if missing
    public DepositeEntity saveTransaction(DepositeEntity transaction) {
        if (transaction.getTransactionId() == null || transaction.getTransactionId().isEmpty()) {
            transaction.setTransactionId(UUID.randomUUID().toString());
        }
        transactionMap.put(transaction.getTransactionId(), transaction);
        return transaction;
    }

    // Get transaction by ID
    public Optional<DepositeEntity> getTransactionById(String id) {
        return Optional.ofNullable(transactionMap.get(id));
    }

    // Get all transactions
    public List<DepositeEntity> getAllTransactions() {
        return new ArrayList<>(transactionMap.values());
    }

    // Update transaction by ID
    public DepositeEntity updateTransaction(String id, DepositeEntity updatedTransaction) {
        if (!transactionMap.containsKey(id)) {
            throw new NoSuchElementException("Transaction with ID " + id + " not found");
        }
        updatedTransaction.setTransactionId(id);
        transactionMap.put(id, updatedTransaction);
        return updatedTransaction;
    }

    // Delete transaction by ID
    public boolean deleteTransaction(String id) {
        return transactionMap.remove(id) != null;
    }
}
