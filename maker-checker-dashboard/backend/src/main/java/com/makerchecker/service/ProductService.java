package com.makerchecker.service;

import com.makerchecker.ProductApprovalView;
import com.makerchecker.ProductSubmission;
import com.makerchecker.model.Approval;
import com.makerchecker.model.CheckerDecision;
import com.makerchecker.model.Product;
import com.makerchecker.repository.ApprovalRepository;
import com.makerchecker.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private ApprovalRepository approvalRepo;

    public ProductService(ProductRepository productRepo, ApprovalRepository approvalRepo) {
        this.productRepo = productRepo;
        this.approvalRepo = approvalRepo;
    }

    public void submitProduct(ProductSubmission submission) {
    //need to save data in product and approval table
        Product product = new Product();
        product.setProductCode(submission.getProduct_code());
        product.setRateOfIntrest(submission.getRate_of_intrest());
        product.setEffectiveFromDate(submission.getEffectiveFromDate());
        product.setEffectiveToDate(submission.getEffectiveToDate());
        product.setIsActive(submission.getIsActive());
        productRepo.save(product);

        Approval approval = new Approval();
        approval.setProduct_id(product.getId());
        approval.setUser_id(submission.getUser_id());
        approval.setUser_role(submission.getUser_role());
        approval.setStatus("PENDING");
        approvalRepo.save(approval);

    }

    public List<ProductApprovalView> getMakerProducts(Long makerId) {
        return approvalRepo.findByMakerIdWithProduct(makerId);
    }

    public List<ProductApprovalView> getCheckerPending(Long checkerId) {
        return approvalRepo.findPendingApprovals();
    }

    public void checkerDecision(CheckerDecision decision) {
        Approval approval = approvalRepo.findById(decision.getApprovalId()).orElseThrow();
        approval.setStatus(decision.getStatus());
        approval.setComments(decision.getComments());
        // approval.setChecker_id(decision.getCheckerId());
        approvalRepo.save(approval);
    }
}
