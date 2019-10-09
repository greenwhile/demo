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

    private Integer quantityOrdered;

    private BigDecimal priceEach;

    private Short orderLineNumber;

    //bi-directional many-to-one association to Order
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="orderNumber", insertable=false, updatable=false)
    @ManyToOne
    @JoinColumn(name = "orderNumber", insertable = false, updatable = false)
    private Order order;
//
//    //bi-directional many-to-one association to Product
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="productCode", insertable=false, updatable=false)
    @ManyToOne
    @JoinColumn(name = "productCode", insertable = false, updatable = false)
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailPK orderDetailPK, Short orderLineNumber, BigDecimal priceEach, Integer quantityOrdered) {
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

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public Short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailPK=" + orderDetailPK +
                ", quantityOrdered=" + quantityOrdered +
                ", priceEach=" + priceEach +
                ", orderLineNumber=" + orderLineNumber +
                '}';
    }

}
