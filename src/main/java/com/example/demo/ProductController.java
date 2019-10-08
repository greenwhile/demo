package com.example.demo;

import com.example.model.Product;
import com.example.repository.ProductLineRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
//        products = new ArrayList<Product>();
//        products.add(new Product("S10_1841", new BigDecimal(123.89), new BigDecimal(7933), "This replica features working kickstand, front suspension, gear-shift lever, footbrake lever", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", (short)7933));
//        products.add(new Product("S10_1473", new BigDecimal(783.47), new BigDecimal(8754), "This description description description", "1969 Harley Davidson Ultimate Chopper", "Motorcycles", "1:10", "Min Lin Diecast", (short)7863));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<Product> getAffordable(@PathVariable BigDecimal price){
        return productRepository.findByBuyPriceLessThan(price); // products.stream().filter(x -> (double)Double.parseDouble(x.getBuyPrice().toString()) <= (double)Double.parseDouble(price.toString())).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Product> create(@RequestBody Product product){
        productRepository.save(product);
        return productRepository.findAll();
    }

    @RequestMapping(value = "/find/{productCode}", method = RequestMethod.GET)
    public Product findByProductCode(@PathVariable String productCode){
        return productRepository.findByProductCode(productCode);
    }

}
