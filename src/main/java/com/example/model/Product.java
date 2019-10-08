package com.example.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    private String productCode;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
    private String productDescription;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private short quantityInStock;

    //bi-directional many-to-one association to Orderdetail
    @OneToMany(mappedBy="product", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<OrderDetail> orderdetails;

    //bi-directional many-to-one association to Productline
    @ManyToOne
    @JoinColumn(name="productLine", insertable=false, updatable=false)
    private ProductLine category;

    public Product() {
    }

    public Product(String productCode, BigDecimal buyPrice, BigDecimal msrp, String productDescription, String productName, String productLine, String productScale, String productVendor, short quantityInStock) {
        this.productCode = productCode;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
        this.productDescription = productDescription;
        this.productName = productName;
        this.productLine = productLine;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.quantityInStock = quantityInStock;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public List<OrderDetail> getOrderdetails() {
        return orderdetails;
    }

    public void setOrderdetails(List<OrderDetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public ProductLine getCategory() {
        return category;
    }

    public void setCategory(ProductLine category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return quantityInStock == product.quantityInStock &&
                Objects.equals(productCode, product.productCode) &&
                Objects.equals(buyPrice, product.buyPrice) &&
                Objects.equals(msrp, product.msrp) &&
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productLine, product.productLine) &&
                Objects.equals(productScale, product.productScale) &&
                Objects.equals(productVendor, product.productVendor) &&
                Objects.equals(orderdetails, product.orderdetails) &&
                Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productCode, buyPrice, msrp, productDescription, productName, productLine, productScale, productVendor, quantityInStock, orderdetails, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", buyPrice=" + buyPrice +
                ", msrp=" + msrp +
                ", productDescription='" + productDescription + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productScale='" + productScale + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", orderdetails=" + orderdetails +
                ", category=" + category +
                '}';
    }
}