package com.springboot.jpa.effort;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springboot.jpa.effort.services.ProductService;
import com.springboot.jpa.effort.services.ProductServiceImpl;

@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.springboot.jpa.effort.repositories" })
@ComponentScan("com.springboot.jpa.effort")
@PropertySource("classpath:application.properties")
public class JPAConfiguration {

    @Bean
    public ProductService productService() {
        return new ProductServiceImpl();
    }
}
