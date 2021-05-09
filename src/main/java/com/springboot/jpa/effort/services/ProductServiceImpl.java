package com.springboot.jpa.effort.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.jpa.effort.entities.Product;
import com.springboot.jpa.effort.repositories.ProductRepository;

@Transactional
@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAllBetweenStoredProcedure(BigDecimal min, BigDecimal max) {
        return productRepository.findAllBetweenStoredProcedure(min, max);
    }

    @Override
    public List<Product> findTopN(int n) {
        return productRepository.findTopN(n);
    }

}
