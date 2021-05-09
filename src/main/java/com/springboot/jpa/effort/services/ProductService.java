package com.springboot.jpa.effort.services;
import java.math.BigDecimal;
import java.util.List;
import com.springboot.jpa.effort.entities.Product;

public interface ProductService {

    public List<Product> findAllBetweenStoredProcedure(BigDecimal min, BigDecimal max);

    public List<Product> findTopN(int n);

}
