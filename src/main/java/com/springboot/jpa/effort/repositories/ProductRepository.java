package com.springboot.jpa.effort.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.springboot.jpa.effort.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query(value = "{call sp_findBetween(:min, :max)}", nativeQuery = true)
    public List<Product> findAllBetweenStoredProcedure(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

}
