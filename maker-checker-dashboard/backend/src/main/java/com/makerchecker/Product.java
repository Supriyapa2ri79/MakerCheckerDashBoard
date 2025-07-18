package com.example.makerchecker;
import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_code;
    private Double rate_of_intrest;
    private String effective_from_date;
    private String effective_to_date;
    private boolean is_active;

    public Product() {}

    public Product(String product_code, Double rate_of_intrest,String effective_from_date,String effective_to_date,
                   boolean is_active) {
        this.product_code = product_code;
        this.rate_of_intrest = rate_of_intrest;
        this.effective_from_date = effective_from_date;
        this.effective_to_date = effective_to_date;
        this.is_active = is_active;
    }

    // Getters and setters omitted for brevity
}
