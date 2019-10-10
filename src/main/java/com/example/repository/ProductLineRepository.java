package com.example.repository;

import com.example.model.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine,String> {
    List<ProductLine> findAll();

    @Query("SELECT pl.productLine, p.productName FROM ProductLine pl INNER JOIN pl.products p")
    List<Object[]> fetchProductLinesInnerJoinProducts();

    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach FROM ProductLine pl " +
            "INNER JOIN pl.products p " +
            "INNER JOIN p.orderdetails od")
    List<Object[]> fetchProductLinesInnerJoinOrderDetails();

    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach, o.orderDate, o.requiredDate FROM ProductLine pl " +
            "INNER JOIN pl.products p " +
            "INNER JOIN p.orderdetails od " +
            "INNER JOIN od.order o")  // look at mappedBy = "order" in Order Class above List<OrderDetail> orderdetails
    List<Object[]> fetchProductLinesInnerJoinOrders();

    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach, o.orderDate, o.requiredDate, c.customerName FROM ProductLine pl " +
            "INNER JOIN pl.products p " +
            "INNER JOIN p.orderdetails od " +
            "INNER JOIN od.order o " +
            "INNER JOIN o.order_customer c")
    List<Object[]> fetchProductLinesInnerJoinCustomers();

//    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach, o.orderDate, o.requiredDate, c.customerName FROM ProductLine pl " +
//            "INNER JOIN pl.products p " +
//            "INNER JOIN p.orderdetails od " +
//            "INNER JOIN od.order o " +
//            "INNER JOIN o.order_customer c " +
//            "INNER JOIN c.payment_customer p")
//    List<Object[]> fetchProductLinesInnerJoinPayments();
//
//    @Query("SELECT c.customerName, p.amount FROM Customer c INNER JOIN c.payment_customer p")
//    List<Object[]> myQuestion();

    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach, o.orderDate, o.requiredDate, c.customerName, e.firstName FROM ProductLine pl " +
            "INNER JOIN pl.products p " +
            "INNER JOIN p.orderdetails od " +
            "INNER JOIN od.order o " +
            "INNER JOIN o.order_customer c " +
            "INNER JOIN c.employee e")
    List<Object[]> fetchProductLinesInnerJoinEmployees();

    @Query("SELECT pl.productLine, p.productName, od.quantityOrdered, od.priceEach, o.orderDate, o.requiredDate, c.customerName, e.firstName, f.addressLine1 FROM ProductLine pl " +
            "INNER JOIN pl.products p " +
            "INNER JOIN p.orderdetails od " +
            "INNER JOIN od.order o " +
            "INNER JOIN o.order_customer c " +
            "INNER JOIN c.employee e " +
            "INNER JOIN e.office f")
    List<Object[]> fetchProductLinesInnerJoinOffices();

}
