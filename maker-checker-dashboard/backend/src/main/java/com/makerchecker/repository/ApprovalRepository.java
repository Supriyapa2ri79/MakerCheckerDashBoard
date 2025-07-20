package com.makerchecker.repository;
import com.makerchecker.ProductApprovalView;
import com.makerchecker.model.Approval;
import com.makerchecker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {
    @Query("SELECT new com.makerchecker.ProductApprovalView(a.id, p.product_code, p.rate_of_intrest, a.status, a.comments, a.maker_id) FROM Approval a JOIN Product p ON a.product_id = p.id WHERE a.maker_id = ?1")
    List<ProductApprovalView> findByMakerIdWithProduct(Long makerId);

    @Query("SELECT new com.makerchecker.ProductApprovalView(a.id, p.product_code, p.rate_of_intrest, a.status, a.comments, a.maker_id) FROM Approval a JOIN Product p ON a.product_id = p.id WHERE a.status = 'Pending'")
    List<ProductApprovalView> findPendingApprovals();
}
