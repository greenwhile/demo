package com.example.demo;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@Component
public class DatabaseSeeder /*implements CommandLineRunner*/ {

//    private ProductRepository productRepository;
//
//    @Autowired
//    public DatabaseSeeder(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Product> products = new ArrayList<Product>();
//        products.add(new Product("S10_1841", new BigDecimal(123.89), new BigDecimal(7933), "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", (short)7933));
//        products.add(new Product("S10_1473", new BigDecimal(783.47), new BigDecimal(8754), "This description description description", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", (short)7863));
////        productRepository.saveAll(products);
//    }
}
