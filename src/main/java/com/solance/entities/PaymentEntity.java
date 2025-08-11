package com.solance.entities;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentEntity {

    private String id;
    private String userId;
    private String solanceTo;
    private double rate;
    private String amountSell;
    private String amountBuy;
    private String solanceFrom;
    private LocalDateTime timePlaced;
    private String beneficiaryIBAN;
    private String originatingCountry;
    private String paymentRef;
    private String invoiceNumber;
    private String purposeRef;
    private String invoicePayment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSolanceTo() {
        return solanceTo;
    }

    public void setSolanceTo(String solanceTo) {
        this.solanceTo = solanceTo;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getAmountSell() {
        return amountSell;
    }

    public void setAmountSell(String amountSell) {
        this.amountSell = amountSell;
    }

    public String getAmountBuy() {
        return amountBuy;
    }

    public void setAmountBuy(String amountBuy) {
        this.amountBuy = amountBuy;
    }

    public String getSolanceFrom() {
        return solanceFrom;
    }

    public void setSolanceFrom(String solanceFrom) {
        this.solanceFrom = solanceFrom;
    }

    public LocalDateTime getTimePlaced() {
        return timePlaced;
    }

    public void setTimePlaced(LocalDateTime timePlaced) {
        this.timePlaced = timePlaced;
    }

    public String getBeneficiaryIBAN() {
        return beneficiaryIBAN;
    }

    public void setBeneficiaryIBAN(String beneficiaryIBAN) {
        this.beneficiaryIBAN = beneficiaryIBAN;
    }

    public String getOriginatingCountry() {
        return originatingCountry;
    }

    public void setOriginatingCountry(String originatingCountry) {
        this.originatingCountry = originatingCountry;
    }

    public String getPaymentRef() {
        return paymentRef;
    }

    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPurposeRef() {
        return purposeRef;
    }

    public void setPurposeRef(String purposeRef) {
        this.purposeRef = purposeRef;
    }

    public String getInvoicePayment() {
        return invoicePayment;
    }

    public void setInvoicePayment(String invoicePayment) {
        this.invoicePayment = invoicePayment;
    }
}
