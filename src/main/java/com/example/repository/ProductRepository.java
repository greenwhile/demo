package com.example.repository;

import com.example.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findAll();
    @Query("select b from Product b where b.productCode = :productCode")
    Product findByProductCode(@Param("productCode") String productCode);
    Optional<Product> findById(String id);
    void deleteById(String id);
    @Query("update Product p set p.buyPrice = ?1, p.msrp = ?2, p.productDescription = ?3, p.productName = ?4, p.productLine = ?5, p.productScale = ?6, p.productVendor = ?7, p.quantityInStock = ?8 where p.productCode = ?9")
    void update(BigDecimal buyPrice, BigDecimal msrp, String productDescription, String productName, String productLine, String productScale, String productVendor, Short quantityInStock);

    List<Product> findByProductLine(String productLine);
    List<Product> findByBuyPriceLessThan(BigDecimal price);
    List<Product> findByBuyPriceAndQuantityInStock(BigDecimal buyPrice, Short quantityInStock);
    List<Product> findByProductNameEquals(String productName);
}
