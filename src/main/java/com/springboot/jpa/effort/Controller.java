package com.springboot.jpa.effort;

import com.springboot.jpa.effort.entities.Product;
import com.springboot.jpa.effort.repositories.ProductRepository;
import com.springboot.jpa.effort.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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

    @GetMapping("/list")
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/filter")
    public Iterable<Product> filterValues() {

        return productRepository.findAllBetweenStoredProcedure(BigDecimal.valueOf(4), BigDecimal.valueOf(8));

    }
}

