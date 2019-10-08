package com.example.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="orders")
public class Order {

    private static int ordersCount;

    @Id
    @GeneratedValue
    private int orderNumber;

    @Lob
    @Type(type = "org.hibernate.type.MaterializedClobType")
    @Column(length = Integer.MAX_VALUE)
    private String comments;

    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Temporal(TemporalType.DATE)
    private Date requiredDate;

    @Temporal(TemporalType.DATE)
    private Date shippedDate;

    private String status;

    private int customerNumber;

    //bi-directional many-to-one association to Orderdetail
    @OneToMany(mappedBy="order")
    private List<OrderDetail> orderdetails;

    //bi-directional many-to-one association to Customer
    @ManyToOne
    @JoinColumn(name="customerNumber", insertable=false, updatable=false)
    private Customer customer;

    public Order() {
    }

    public Order(String comments, Date orderDate, Date requiredDate, Date shippedDate, String status,
                 int customerNumber) {
        super();
        this.orderNumber = ++ordersCount;
        this.comments = comments;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.customerNumber = customerNumber;
    }

    public static int getOrdersCount() {
        return ordersCount;
    }

    public static void setOrdersCount(int ordersCount) {
        Order.ordersCount = ordersCount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<OrderDetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrderDetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return orderNumber == order.orderNumber &&
                customerNumber == order.customerNumber &&
                Objects.equals(comments, order.comments) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(requiredDate, order.requiredDate) &&
                Objects.equals(shippedDate, order.shippedDate) &&
                Objects.equals(status, order.status) &&
                Objects.equals(orderdetails, order.orderdetails) &&
                Objects.equals(customer, order.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, comments, orderDate, requiredDate, shippedDate, status, customerNumber, orderdetails, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", comments='" + comments + '\'' +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status='" + status + '\'' +
                ", customerNumber=" + customerNumber +
                ", orderdetails=" + orderdetails +
                ", customer=" + customer +
                '}';
    }

}