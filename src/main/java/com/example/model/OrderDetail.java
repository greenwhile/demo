package com.example.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="orderdetails")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPK orderDetailPK;

    private int quantityOrdered;

    private BigDecimal priceEach;

    private short orderLineNumber;

    //bi-directional many-to-one association to Order
    @ManyToOne
    @JoinColumn(name="orderNumber", insertable=false, updatable=false)
    private Order order;

    //bi-directional many-to-one association to Product
    @ManyToOne
    @JoinColumn(name="productCode", insertable=false, updatable=false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK, short orderLineNumber, BigDecimal priceEach, int quantityOrdered) {
        super();
        this.orderDetailPK = orderDetailPK;
        this.orderLineNumber = orderLineNumber;
        this.priceEach = priceEach;
        this.quantityOrdered = quantityOrdered;
    }

    public OrderDetailPK getOrderDetailPK() {
        return orderDetailPK;
    }

    public void setOrderDetailPK(OrderDetailPK orderDetailPK) {
        this.orderDetailPK = orderDetailPK;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetail)) return false;
        OrderDetail that = (OrderDetail) o;
        return quantityOrdered == that.quantityOrdered &&
                orderLineNumber == that.orderLineNumber &&
                Objects.equals(orderDetailPK, that.orderDetailPK) &&
                Objects.equals(priceEach, that.priceEach) &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderDetailPK, quantityOrdered, priceEach, orderLineNumber, order, product);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                ", order=" + order +
                ", product=" + product +
                '}';
    }

}
