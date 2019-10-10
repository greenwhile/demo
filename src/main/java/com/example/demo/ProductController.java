package com.example.demo;

import com.example.model.Product;
import com.example.repository.ProductLineRepository;
import com.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @RequestMapping(value = "/find/one/{id}", method = RequestMethod.GET)
    public Optional<Product> findOneProduct(@PathVariable String id){
        return productRepository.findById(id);
    }

    @RequestMapping(value = "/find/{productCode}", method = RequestMethod.GET)
    public Product findByProductCode(@PathVariable String productCode){
        return productRepository.findByProductCode(productCode);
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

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public List<Product> delete(@PathVariable String id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<Product> update(@RequestBody Product product){
        Product findedProduct = productRepository.findByProductCode(product.getProductCode());
        findedProduct.setBuyPrice(product.getBuyPrice());
        findedProduct.setMsrp(product.getMsrp());
        findedProduct.setProductDescription(product.getProductDescription());
        findedProduct.setProductName(product.getProductName());
        findedProduct.setProductLine(product.getProductLine());
        findedProduct.setProductScale(product.getProductScale());
        findedProduct.setProductVendor(product.getProductVendor());
        findedProduct.setQuantityInStock(product.getQuantityInStock());
        productRepository.save(findedProduct);
        return productRepository.findAll();
    }

    @RequestMapping(value = "/find/price/quantity", method = RequestMethod.GET)
    public List<Product> findByBuyPriceAndQuantityInStock(Double buyPrice, String quantityInStock){
        BigDecimal price = BigDecimal.valueOf(new Double(buyPrice));
        Short quantity = Short.valueOf(new String(quantityInStock));
        return productRepository.findByBuyPriceAndQuantityInStock(price, quantity);
    }

    @RequestMapping(value = "/find/name", method = RequestMethod.GET)
    public List<Product> findByProductNameEquals(String productName){
        return productRepository.findByProductNameEquals(new String(productName));
    }

    @RequestMapping(value = "/find/line", method = RequestMethod.GET)
    public List<Product> findByProductLine(String productLine){
        return productRepository.findByProductLine(new String(productLine));
    }

}
