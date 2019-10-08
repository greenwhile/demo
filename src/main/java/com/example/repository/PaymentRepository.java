package com.example.repository;

import com.example.model.Payment;
import com.example.model.PaymentPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, PaymentPK> {
    List<Payment> findAll();
}
