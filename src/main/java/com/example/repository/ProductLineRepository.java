package com.example.repository;

import com.example.model.ProductLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductLineRepository extends JpaRepository<ProductLine,String> {
    List<ProductLine> findAll();
//    @Modifying
//    @Query("delete from ProductLine where productLine = :productLine")
//    void deleteById(@Param("productLine") String productLine);
//    ProductLine findByProductLine(String productLine);
}
