
package com.example.makerchecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/submit")
    public void submitProduct(@RequestBody ProductSubmission submission) {
        productService.submitProduct(submission);
    }

    @GetMapping("/maker/{userrole_userId}}")
    public List<ProductApprovalView> getMakerProducts(@PathVariable Long makerId) {
        return productService.getMakerProducts(makerId);
    }

    @GetMapping("/checker/{userrole_userId}}")
    public List<ProductApprovalView> getCheckerPending(@PathVariable Long checkerId) {
        return productService.getCheckerPending(checkerId);
    }

    @PostMapping("/decide")
    public void decide(@RequestBody CheckerDecision decision) {
        productService.checkerDecision(decision);
    }
}
