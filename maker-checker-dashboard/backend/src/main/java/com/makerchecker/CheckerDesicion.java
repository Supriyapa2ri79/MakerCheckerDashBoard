package com.example.makerchecker;

public class CheckerDecision {
    private Long approval_id;
    private String status;
    private String comments;
    private Long checker_id;

    public Long getApproval_id() { return approval_id; }
    public void setApproval_id(Long approval_id) { this.approval_id = approval_id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }
    public Long getChecker_id() { return checker_id; }
    public void setChecker_id(Long checker_id) { this.checker_id = checker_id; }
}
