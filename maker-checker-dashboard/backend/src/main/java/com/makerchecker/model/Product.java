package com.makerchecker.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Matches SERIAL in SQL
    private Long id;

    @Column(name = "product_code", length = 50)
    private String productCode;

    @Column(name = "rate_of_intrest", precision = 5, scale = 2)
    private Double rateOfIntrest;

    @Column(name = "effective_from_date")
    private LocalDate effectiveFromDate;

    @Column(name = "effective_to_date")
    private LocalDate effectiveToDate;

    @Column(name = "is_active")
    private Boolean isActive;

    // Constructors
    public Product() {}

    public Product(String productCode, Double rateOfIntrest, LocalDate effectiveFromDate,
                   LocalDate effectiveToDate, Boolean isActive) {
        this.productCode = productCode;
        this.rateOfIntrest = rateOfIntrest;
        this.effectiveFromDate = effectiveFromDate;
        this.effectiveToDate = effectiveToDate;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public Double getRateOfIntrest() { return rateOfIntrest; }
    public void setRateOfIntrest(Double rateOfIntrest) { this.rateOfIntrest = rateOfIntrest; }

    public LocalDate getEffectiveFromDate() { return effectiveFromDate; }
    public void setEffectiveFromDate(LocalDate effectiveFromDate) { this.effectiveFromDate = effectiveFromDate; }

    public LocalDate getEffectiveToDate() { return effectiveToDate; }
    public void setEffectiveToDate(LocalDate effectiveToDate) { this.effectiveToDate = effectiveToDate; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}