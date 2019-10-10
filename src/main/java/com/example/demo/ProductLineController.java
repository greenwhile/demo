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

    @RequestMapping(value = "/innerjoin/products", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinProducts(){
        return productLineRepository.fetchProductLinesInnerJoinProducts();
    }

    @RequestMapping(value = "/innerjoin/orderdetails", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinOrderDetails(){
        return productLineRepository.fetchProductLinesInnerJoinOrderDetails();
    }

    @RequestMapping(value = "/innerjoin/orders", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinOrders(){
        return productLineRepository.fetchProductLinesInnerJoinOrders();
    }

    @RequestMapping(value = "/innerjoin/customers", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinCustomers(){
        return productLineRepository.fetchProductLinesInnerJoinCustomers();
    }

//    @RequestMapping(value = "/innerjoin/payments", method = RequestMethod.GET)
//    List<Object[]> fetchProductLinesInnerJoinPayments(){
//        return productLineRepository.fetchProductLinesInnerJoinPayments();
//    }

    @RequestMapping(value = "/innerjoin/employees", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinEmployees(){
        return productLineRepository.fetchProductLinesInnerJoinEmployees();
    }

    @RequestMapping(value = "/innerjoin/offices", method = RequestMethod.GET)
    List<Object[]> fetchProductLinesInnerJoinOffices(){
        return productLineRepository.fetchProductLinesInnerJoinOffices();
    }

}
