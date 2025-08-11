package com.solance.repositories;

import com.solance.entities.PaymentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<PaymentEntity,String> {
}
