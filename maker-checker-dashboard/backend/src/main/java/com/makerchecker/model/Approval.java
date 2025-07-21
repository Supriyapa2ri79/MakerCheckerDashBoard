package com.makerchecker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long product_id;
    private Long user_id;
    private String user_role;
    private String status;
    private String comments;

    // Default constructor required by JPA
    public Approval() {}

    // Parameterized constructor for easier instantiation
    public Approval(Long product_id, Long user_id,String user_role, String status, String comments) {
        this.product_id = product_id;
        this.user_id = user_id;
        this.status = status;
        this.comments = comments;
        this.user_role = user_role;
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

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public String getUser_role() {
        return user_role;
    }
    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
}