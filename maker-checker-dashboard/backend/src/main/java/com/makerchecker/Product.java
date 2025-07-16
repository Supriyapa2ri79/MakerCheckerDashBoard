package com.example.makerchecker;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_code;
    private Double rate_of_intrest;

    public Product() {}

    public Product(String product_code, Double rate_of_intrest) {
        this.product_code = product_code;
        this.rate_of_intrest = rate_of_intrest;
    }

    // Getters and setters omitted for brevity
}
