package com.makerchecker;

public class ProductApprovalView {
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
