package com.example.repository;

import com.example.model.Customer;
import com.example.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office,String> {
    List<Office> findAll();
}
