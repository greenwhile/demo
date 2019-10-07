package com.example.service;

import com.example.model.ProductLine;
import com.example.repository.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductLineService {
    @Autowired
    private ProductLineRepository productLineRepository;
    public List<ProductLine> findAll(){return productLineRepository.findAll();}
//    public void deleteById(String id){ productLineRepository.deleteById(id); }
}
