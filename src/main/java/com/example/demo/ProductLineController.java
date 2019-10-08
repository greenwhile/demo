package com.example.demo;

import com.example.model.Product;
import com.example.model.ProductLine;
import com.example.repository.ProductLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class ProductLineController {

    private ProductLineRepository productLineRepository;

    @Autowired
    public ProductLineController(ProductLineRepository productLineRepository) {
        this.productLineRepository = productLineRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<ProductLine> getAll(){
        return productLineRepository.findAll();
    }

}
