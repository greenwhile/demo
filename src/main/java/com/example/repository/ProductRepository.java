package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product,String> {
//    List<Product> findByCategory(String productCode/*, Pageable p*/);
    List<Product> findAll();
    @Query("select b from Product b where b.productCode = :productCode")
    Product findByProductCode(@Param("productCode") String productCode);
//    Product findOne(String productCode);
//    Product findByProductCode(String productCode);
//    void delete(String id);
//    void update(Product product);
    List<Product> findByBuyPriceLessThan(BigDecimal price);
}
