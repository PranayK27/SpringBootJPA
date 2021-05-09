package com.springboot.jpa.effort.main;
import java.math.BigDecimal;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.springboot.jpa.effort.JPAConfiguration;
import com.springboot.jpa.effort.entities.Product;
import com.springboot.jpa.effort.services.ProductService;

public class Demo {

    public static void main(String[] args) {
        try {
            AbstractApplicationContext context = new AnnotationConfigApplicationContext(JPAConfiguration.class);
            ProductService productService = context.getBean(ProductService.class);
            System.out.println("Find product have price between 4 and 8");
            for (Product product : productService.findAllBetweenStoredProcedure(BigDecimal.valueOf(4), BigDecimal.valueOf(8))) {
                System.out.println("Id: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("========================");
            }
            context.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
