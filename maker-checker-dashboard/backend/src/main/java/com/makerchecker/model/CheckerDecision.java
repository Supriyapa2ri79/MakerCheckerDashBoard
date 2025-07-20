package com.makerchecker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CheckerDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long approvalId;
    private String status;
    private String comments;
    private Long checkerId;

    public CheckerDecision() {}

    public CheckerDecision(Long approvalId, String status, String comments, Long checkerId) {
        this.approvalId = approvalId;
        this.status = status;
        this.comments = comments;
        this.checkerId = checkerId;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public Long getApprovalId() {
        return approvalId;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public Long getCheckerId() {
        return checkerId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCheckerId(Long checkerId) {
        this.checkerId = checkerId;
    }
}