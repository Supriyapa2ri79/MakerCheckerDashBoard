package com.makerchecker.model;
import javax.persistence.*;

@Entity
public class Approval {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product_id;
    private Long maker_id;
    private Long checker_id;
    private String status;
    private String comments;

    public Approval() {}

    public Approval(Long product_id, Long maker_id, Long checker_id, String status, String comments) {
        this.product_id = product_id;
        this.maker_id = maker_id;
        this.checker_id = checker_id;
        this.status = status;
        this.comments = comments;
    }

    // Getters and setters omitted for brevity
}
