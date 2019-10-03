package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
//    List<Product> findByCategory(String productCode/*, Pageable p*/);
    List<Product> findAll();
//    Product findOne(String productCode);
//    Product findByProductCode(String productCode);
//    void delete(String productCode);
//    void update(Product product);
    List<Product> findByBuyPriceLessThan(BigDecimal price);
}
