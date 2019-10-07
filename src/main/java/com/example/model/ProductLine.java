package com.example.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="productlines")
public class ProductLine implements Serializable {

    @Id
    private String productLine;

    @Type(type = "org.hibernate.type.MaterializedClobType")
    @Column(length = Integer.MAX_VALUE)
    private String htmlDescription;

    @Lob
    @Column(name="image", length = Integer.MAX_VALUE)
    private byte[] file;

    //bi-directional many-to-one association to Product
    @OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Product> products;

//    @ManyToOne
//    @JoinColumn(name = "userNumber", insertable=false, updatable=false)
//    private User user;


    public ProductLine() {
    }

    public ProductLine(String productLine, String htmlDescription, byte[] file) {
        super();
        this.productLine = productLine;
        this.htmlDescription = htmlDescription;
        this.file = file;
    }

    public String getProductLine() {
        return this.productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getHtmlDescription() {
        return this.htmlDescription;
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
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product addProduct(Product product) {
        getProducts().add(product);
        product.setCategory(this);

        return product;
    }

    public Product removeProduct(Product product) {
        getProducts().remove(product);
        product.setCategory(null);

        return product;
    }

}
