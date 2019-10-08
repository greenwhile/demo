package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PaymentPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="customerNumber", insertable=false, updatable=false)
    private int customerNumber;

    @Column(name="checkNumber", insertable=false, updatable=false)
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(Integer customerNumber, String checkNumber) {
        super();
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public int getCustomerNumber() {
        return this.customerNumber;
    }
    public String getCheckNumber() {
        return this.checkNumber;
    }
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentPK)) {
            return false;
        }
        PaymentPK castOther = (PaymentPK)other;
        return
                (this.customerNumber == castOther.customerNumber)
                        && this.checkNumber.equals(castOther.checkNumber);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.customerNumber;
        hash = hash * prime + this.checkNumber.hashCode();

        return hash;
    }
}