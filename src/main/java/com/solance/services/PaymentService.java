package com.solance.services;

import com.solance.entities.PaymentEntity;
import com.solance.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentrepository;

    public PaymentEntity  savePayment(PaymentEntity paymentEntity) {
        paymentEntity.setTimePlaced(LocalDateTime.now());
        return paymentrepository.save(paymentEntity);
    }

    public List<PaymentEntity> getAllPayments() {
        return paymentrepository.findAll();
    }


    public Optional<PaymentEntity> getPaymentInstructionByID(String id) {
        return paymentrepository.findById(id);
    }




    public PaymentEntity updatePaymentInstruction(String id, PaymentEntity updatedPayment) {
        PaymentEntity existingPayment = paymentrepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Payment instruction not found with id: " + id));

        existingPayment.setUserId(updatedPayment.getUserId());
        existingPayment.setSolanceTo(updatedPayment.getSolanceTo());
        existingPayment.setRate(updatedPayment.getRate());
        existingPayment.setAmountSell(updatedPayment.getAmountSell());
        existingPayment.setAmountBuy(updatedPayment.getAmountBuy());
        existingPayment.setSolanceFrom(updatedPayment.getSolanceFrom());
        // We can perform validation here like  saving Current time
        existingPayment.setTimePlaced(LocalDateTime.now());
        existingPayment.setBeneficiaryIBAN(updatedPayment.getBeneficiaryIBAN());
        existingPayment.setOriginatingCountry(updatedPayment.getOriginatingCountry());
        existingPayment.setPaymentRef(updatedPayment.getPaymentRef());
        existingPayment.setInvoiceNumber(updatedPayment.getInvoiceNumber());
        existingPayment.setPurposeRef(updatedPayment.getPurposeRef());
        existingPayment.setInvoicePayment(updatedPayment.getInvoicePayment());

        return paymentrepository.save(existingPayment);
    }

    public Boolean deletePaymentInstruction(String id){
        if (paymentrepository.existsById(id)) {
            paymentrepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


}


