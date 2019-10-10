package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="payments")
public class Payment {

    @EmbeddedId
    private PaymentPK paymentPK;
    private BigDecimal amount;
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @ManyToOne
    @JoinColumn(name = "customerNumber", insertable = false, updatable = false)
    private Customer payment_customer;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK, BigDecimal amount, Date paymentDate) {
        super();
        this.paymentPK = paymentPK;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public PaymentPK getPaymentPK() {
        return paymentPK;
    }

    public void setPaymentPK(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentPK=" + paymentPK +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }

}