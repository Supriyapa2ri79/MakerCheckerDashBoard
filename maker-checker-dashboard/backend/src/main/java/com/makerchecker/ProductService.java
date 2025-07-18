package com.example.makerchecker;

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

    public void submitProduct(ProductSubmission submission) {

        List<Product> prod = productRepo.findProductById(submission.getProduct_code());
        if(prod != null && prod.count > 0) {
            for (Product product : prod) {
                if (product.isActive()) {
                    product.effective_to_date(LocalDate.now());
                    product.is_active(false);
                    productRepo.save(prod);
                    Product prod = new Product(submission.getProduct_code(), submission.getRate_of_intrest(),null,null,true);
                    productRepo.save(prod);
                }
            }
        }else{
            Product prod = new Product(submission.getProduct_code(), submission.getRate_of_intrest()null,null,null);
            productRepo.save(prod);
        }
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
