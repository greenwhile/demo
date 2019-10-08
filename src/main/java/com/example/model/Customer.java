package com.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="customers")
public class Customer {

    private static int customersCount;

    @Id
    @GeneratedValue
    private int customerNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String contactFirstName;

    private String contactLastName;

    private String country;

    private BigDecimal creditLimit;

    private String customerName;

    private String phone;

    private String postalCode;

    private String state;

    private Integer salesRepEmployeeNumber;

    //bi-directional many-to-one association to Employee
    @ManyToOne
    @JoinColumn(name="salesRepEmployeeNumber", insertable=false, updatable=false)
    private Employee employee;

    //bi-directional many-to-one association to Order
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Order> orders;

    //bi-directional many-to-one association to Payment
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Payment> payments;

    public Customer() {}

    public Customer(String addressLine1, String addressLine2, String city, String contactFirstName, String contactLastName,
                    String country, BigDecimal creditLimit, String customerName, String phone, String postalCode,
                    int salesRepEmployeeNumber) {
        super();
        this.customerNumber = ++customersCount;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.contactFirstName = contactFirstName;
        this.contactLastName = contactLastName;
        this.country = country;
        this.creditLimit = creditLimit;
        this.customerName = customerName;
        this.phone = phone;
        this.postalCode = postalCode;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public static int getCustomersCount() {
        return customersCount;
    }

    public static void setCustomersCount(int customersCount) {
        Customer.customersCount = customersCount;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Integer salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return customerNumber == customer.customerNumber &&
                Objects.equals(addressLine1, customer.addressLine1) &&
                Objects.equals(addressLine2, customer.addressLine2) &&
                Objects.equals(city, customer.city) &&
                Objects.equals(contactFirstName, customer.contactFirstName) &&
                Objects.equals(contactLastName, customer.contactLastName) &&
                Objects.equals(country, customer.country) &&
                Objects.equals(creditLimit, customer.creditLimit) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(phone, customer.phone) &&
                Objects.equals(postalCode, customer.postalCode) &&
                Objects.equals(state, customer.state) &&
                Objects.equals(salesRepEmployeeNumber, customer.salesRepEmployeeNumber) &&
                Objects.equals(employee, customer.employee) &&
                Objects.equals(orders, customer.orders) &&
                Objects.equals(payments, customer.payments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, addressLine1, addressLine2, city, contactFirstName, contactLastName, country, creditLimit, customerName, phone, postalCode, state, salesRepEmployeeNumber, employee, orders, payments);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", contactFirstName='" + contactFirstName + '\'' +
                ", contactLastName='" + contactLastName + '\'' +
                ", country='" + country + '\'' +
                ", creditLimit=" + creditLimit +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", salesRepEmployeeNumber=" + salesRepEmployeeNumber +
                ", employee=" + employee +
                ", orders=" + orders +
                ", payments=" + payments +
                '}';
    }

}