package com.example.demo;

import com.example.model.OrderDetail;
import com.example.model.Product;
import com.example.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderdetails")
public class OrderDetailController {

    private OrderDetailRepository orderDetailRepository;

    @Autowired
    public OrderDetailController(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<OrderDetail> getAll(){
        return orderDetailRepository.findAll();
    }

}
