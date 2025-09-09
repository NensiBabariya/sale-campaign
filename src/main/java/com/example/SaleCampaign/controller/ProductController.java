package com.example.SaleCampaign.controller;

import com.example.SaleCampaign.DTO.AddProductResponseDTO;
import com.example.SaleCampaign.DTO.PaginatedResponseDTO;
import com.example.SaleCampaign.DTO.ProductPricingHistoryResponse;
import com.example.SaleCampaign.DTO.ProductResponseDTO;
import com.example.SaleCampaign.model.Product;
import com.example.SaleCampaign.service.PricingHistoryService;
import com.example.SaleCampaign.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    PricingHistoryService pricingHistoryService;

    @PostMapping("add-product")
    public AddProductResponseDTO addProduct(@RequestBody List<Product> product) {
        return productService.addProducts(product);
    }

    @GetMapping("get-product")//http://localhost:8085/product/get-product?page=3&size=2
    public PaginatedResponseDTO<Product> getPaginatedProducts(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "5") int size) {
        return productService.getProducts(page, size);
    }

    @GetMapping("get-all-products")
    public List<ProductResponseDTO> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("{id}/pricing-history")
    public ResponseEntity<ProductPricingHistoryResponse> getProductPricingHistory(@PathVariable long id) {
        return ResponseEntity.ok(pricingHistoryService.getPricingHistory(id));
    }

}
