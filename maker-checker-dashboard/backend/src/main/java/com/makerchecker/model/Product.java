package com.makerchecker.model;
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

    public static class ProductApprovalView {
        private Long approval_id;
        private String product_code;
        private Double rate_of_intrest;
        private String status;
        private String comments;
        private Long maker_id;

        public ProductApprovalView(Long approval_id, String product_code, Double rate_of_intrest, String status, String comments, Long maker_id) {
            this.approval_id = approval_id;
            this.product_code = product_code;
            this.rate_of_intrest = rate_of_intrest;
            this.status = status;
            this.comments = comments;
            this.maker_id = maker_id;
        }

        // Getters and setters omitted for brevity
    }

    public static class ProductSubmission {
        private String product_code;
        private Double rate_of_intrest;
        private Long maker_id;

        public String getProduct_code() { return product_code; }
        public void setProduct_code(String product_code) { this.product_code = product_code; }
        public Double getRate_of_intrest() { return rate_of_intrest; }
        public void setRate_of_intrest(Double rate_of_intrest) { this.rate_of_intrest = rate_of_intrest; }
        public Long getMaker_id() { return maker_id; }
        public void setMaker_id(Long maker_id) { this.maker_id = maker_id; }
    }
}
