package com.solance.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solance.entities.PaymentEntity;
import com.solance.repositories.PaymentRepository;
import com.solance.services.PaymentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PaymentInstructionTests {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentEntity paymentEntity;


    @Autowired
    private PaymentRepository paymentrepository;

    private String paymentID;


    private ObjectMapper objectMapper = new ObjectMapper();


    // Test for Payment service save payment entry
    // get by id
    // get all
    // delete by id



    @ParameterizedTest
    @ValueSource(strings = {
            "{\"userId\":\"320\",\"solanceFrom\":\"EUR\",\"solanceTo\":\"GBP\",\"amountSell\":1000," +
                    "\"amountBuy\":9890.10,\"rate\":0.7471,\"beneficiaryIBAN\":\"IRL78645789\",\"originatingCountry\":\"FR\"," +
                    "\"paymentRef\":\"3456893\",\"invoiceNumber\":\"456864\",\"purposeRef\":\"Invoice Payment\",\"invoicePayment\":\"7885\"}"
    })
    void PaymentServiceTest_Add_Delete_GetByID(String jsonEntry) throws Exception {
        PaymentEntity paymentEntity = objectMapper.readValue(jsonEntry, PaymentEntity.class);

        PaymentEntity savedPayment = paymentService.savePayment(paymentEntity);

        assertNotNull(savedPayment.getId(), "ID is generated after save");
        paymentID = savedPayment.getId(); // for other tests
        assertNotNull(savedPayment.getTimePlaced(), "timePlaced is set");

        //  verify it exists in DB
        assertTrue(paymentrepository.findById(savedPayment.getId()).isPresent());


        // Get
        Optional<PaymentEntity> retrieved = paymentService.getPaymentInstructionByID(paymentID);
        assertTrue(retrieved.isPresent());

        // Get All
        List<PaymentEntity> paymentsOpt = paymentService.getAllPayments();
        assertNotNull(paymentsOpt, "Never be null");

        // Delete
        boolean deleted = paymentService.deletePaymentInstruction(paymentID);
        assertTrue(deleted);

        // Verify delete
        assertFalse(paymentrepository.findById(paymentID).isPresent());

    }



    @ParameterizedTest
    @ValueSource(strings = {
            "{\"userId\":\"320\",\"solanceFrom\":\"EUR\",\"solanceTo\":\"GBP\",\"amountSell\":1000," +
                    "\"amountBuy\":9890.10,\"rate\":0.7471,\"beneficiaryIBAN\":\"IRL78645789\",\"originatingCountry\":\"FR\"," +
                    "\"paymentRef\":\"3456893\",\"invoiceNumber\":\"456864\",\"purposeRef\":\"Invoice Payment\",\"invoicePayment\":\"7885\"}"
    })
    void PaymentServiceTest_Update_Delete_GetByID(String jsonEntry) throws Exception {
        PaymentEntity paymentEntity = objectMapper.readValue(jsonEntry, PaymentEntity.class);

        PaymentEntity savedPayment = paymentService.savePayment(paymentEntity);
        assertNotNull(savedPayment.getId(), "ID is generated after save");

       // Update the payment entry

        PaymentEntity updatedPayment = new PaymentEntity();
        updatedPayment.setUserId("updatedUser");
        updatedPayment.setSolanceFrom("GBP");
        updatedPayment.setSolanceTo("USD");
        updatedPayment.setAmountSell("200");
        updatedPayment.setAmountBuy("260");
        updatedPayment.setRate(1.3);
        updatedPayment.setBeneficiaryIBAN("UPDATEDIBAN456");
        updatedPayment.setOriginatingCountry("GB");
        updatedPayment.setPaymentRef("updatedRef");
        updatedPayment.setInvoiceNumber("invUpdated");
        updatedPayment.setPurposeRef("Updated Payment");
        updatedPayment.setInvoicePayment("invPayUpdated");

        PaymentEntity result = paymentService.updatePaymentInstruction(savedPayment.getId(), updatedPayment);
        assertNotNull(result, "Updated payment should not be null");
        assertEquals(savedPayment.getId(), result.getId(), "ID should remain the same after update");
        assertEquals("updatedUser", result.getUserId());
        assertEquals("GBP", result.getSolanceFrom());
        assertEquals("USD", result.getSolanceTo());
        assertEquals("200", result.getAmountSell());
        assertEquals("260", result.getAmountBuy());
        assertEquals(1.3, result.getRate());
        assertEquals("UPDATEDIBAN456", result.getBeneficiaryIBAN());
        assertEquals("GB", result.getOriginatingCountry());
        assertEquals("updatedRef", result.getPaymentRef());
        assertEquals("invUpdated", result.getInvoiceNumber());
        assertEquals("Updated Payment", result.getPurposeRef());
        assertEquals("invPayUpdated", result.getInvoicePayment());

        // Delete
        boolean deleted = paymentService.deletePaymentInstruction(savedPayment.getId());
        assertTrue(deleted);

        // Verify delete
        assertFalse(paymentrepository.findById(savedPayment.getId()).isPresent());

    }

    @AfterEach
    void cleanup() {
        if (paymentID != null) {
            paymentService.deletePaymentInstruction(paymentID);
            paymentID = null;
        }
    }



}


