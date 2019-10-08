package com.example.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="productlines")
public class ProductLine {

    @Id
    private String productLine;

    @Type(type = "org.hibernate.type.MaterializedClobType")
    @Column(length = Integer.MAX_VALUE)
    private String htmlDescription;

    @Lob
    @Column(name="image", length = Integer.MAX_VALUE)
    private byte[] file;

    //bi-directional many-to-one association to Product
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(FetchMode.SELECT)
    private List<Product> products;

    public ProductLine() {
    }

    public ProductLine(String productLine, String htmlDescription, byte[] file) {
        super();
        this.productLine = productLine;
        this.htmlDescription = htmlDescription;
        this.file = file;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "ProductLine{" +
                "productLine='" + productLine + '\'' +
                ", htmlDescription='" + htmlDescription + '\'' +
                ", file=" + Arrays.toString(file) +
                ", products=" + products +
                '}';
    }
}
