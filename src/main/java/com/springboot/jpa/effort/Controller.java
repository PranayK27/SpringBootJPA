package com.springboot.jpa.effort;

import com.springboot.jpa.effort.entities.Product;
import com.springboot.jpa.effort.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Controller {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/filterProducts")
    public Iterable<Product> filterValues() {
        return productRepository.findAllBetweenStoredProcedure(BigDecimal.valueOf(4), BigDecimal.valueOf(8));
    }

    @GetMapping("/allProducts")
    public Iterable<Product> findAll(){
        return productRepository.findAllWithStoredProcedure();
    }

    @GetMapping("/topProducts")
    public Iterable<Product> top(){
        return productRepository.findTopN(5);
    }
}

