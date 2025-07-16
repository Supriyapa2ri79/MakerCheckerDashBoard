package com.example.makerchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ApprovalRepository approvalRepo;

    public void submitProduct(ProductSubmission submission) {
        Product prod = new Product(submission.getProduct_code(), submission.getRate_of_intrest());
        productRepo.save(prod);
        Approval approval = new Approval(prod.getId(), submission.getMaker_id(), null, "Pending", null);
        approvalRepo.save(approval);
    }

    public List<ProductApprovalView> getMakerProducts(Long makerId) {
        return approvalRepo.findByMakerIdWithProduct(makerId);
    }

    public List<ProductApprovalView> getCheckerPending(Long checkerId) {
        return approvalRepo.findPendingApprovals();
    }

    public void checkerDecision(CheckerDecision decision) {
        Approval approval = approvalRepo.findById(decision.getApproval_id()).orElseThrow();
        approval.setStatus(decision.getStatus());
        approval.setComments(decision.getComments());
        approval.setChecker_id(decision.getChecker_id());
        approvalRepo.save(approval);
    }
}
