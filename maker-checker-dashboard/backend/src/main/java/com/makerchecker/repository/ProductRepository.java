package com.makerchecker.repository;
import com.makerchecker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.productCode = :productCode")
    List<Product> findProductById(@Param("productCode") String productCode);

}
