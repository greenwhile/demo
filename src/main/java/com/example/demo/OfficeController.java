package com.example.demo;

import com.example.model.Customer;
import com.example.model.Office;
import com.example.repository.OfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/offices")
public class OfficeController {

    private OfficeRepository officeRepository;

    @Autowired
    public OfficeController(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Office> getAll(){
        return officeRepository.findAll();
    }

}
