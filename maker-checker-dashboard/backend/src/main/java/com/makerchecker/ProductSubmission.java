package com.makerchecker;

import java.time.LocalDate;

public class ProductSubmission {
    private String product_code;
    private Double rate_of_intrest;
    private Long user_id;
    private LocalDate effectiveFromDate;
    private LocalDate effectiveToDate;
    private Boolean isActive;
    private String user_role;

    public String getProduct_code() { return product_code; }
    public void setProduct_code(String product_code) { this.product_code = product_code; }
    public Double getRate_of_intrest() { return rate_of_intrest; }
    public void setRate_of_intrest(Double rate_of_intrest) { this.rate_of_intrest = rate_of_intrest; }
    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }
    public LocalDate getEffectiveFromDate() { return effectiveFromDate; }

    public void setEffectiveFromDate(LocalDate effectiveFromDate) {
        this.effectiveFromDate = effectiveFromDate;
    }

    public LocalDate getEffectiveToDate() { return effectiveToDate; }
    public void setEffectiveToDate(LocalDate effectiveToDate) {
        this.effectiveToDate = effectiveToDate;
    }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }

    public String getUser_role() { return user_role; }
    public void setUser_role(String user_role) { this.user_role = user_role; }


}
