package com.example.makerchecker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.productCode = :productCode")
    List<Product> findProductById(@Param("productCode") String productCode);

}
