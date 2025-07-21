package com.makerchecker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product_id;
    private Long maker_id;
    private Long checker_id;
    private String status;
    private String comments;

    // Default constructor required by JPA
    public Approval() {}

    // Parameterized constructor for easier instantiation
    public Approval(Long product_id, Long maker_id, Long checker_id, String status, String comments) {
        this.product_id = product_id;
        this.maker_id = maker_id;
        this.checker_id = checker_id;
        this.status = status;
        this.comments = comments;
    }

    // 🛠 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getMaker_id() {
        return maker_id;
    }

    public void setMaker_id(Long maker_id) {
        this.maker_id = maker_id;
    }

    public Long getChecker_id() {
        return checker_id;
    }

    public void setChecker_id(Long checker_id) {
        this.checker_id = checker_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}