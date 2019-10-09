package com.example.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PaymentPK implements Serializable {

    @Column(name="customerNumber", insertable=false, updatable=false)
    private Integer customerNumber;

    @Column(name="checkNumber", insertable=false, updatable=false)
    private String checkNumber;

    public PaymentPK() {
    }

    public PaymentPK(Integer customerNumber, String checkNumber) {
        super();
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public Integer getCustomerNumber() {
        return this.customerNumber;
    }
    public String getCheckNumber() {
        return this.checkNumber;
    }
    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentPK)) return false;
        PaymentPK paymentPK = (PaymentPK) o;
        return Objects.equals(customerNumber, paymentPK.customerNumber) &&
                Objects.equals(checkNumber, paymentPK.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }
}
