package com.example.model;

import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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
    private Byte[] file;

    //bi-directional many-to-one association to Product
//    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//    @Fetch(FetchMode.SELECT)
//    @BatchSize(size=1)
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    public ProductLine() {
    }

    public ProductLine(String productLine, String htmlDescription, Byte[] file) {
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

    public Byte[] getFile() {
        return file;
    }

    public void setFile(Byte[] file) {
        this.file = file;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

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
