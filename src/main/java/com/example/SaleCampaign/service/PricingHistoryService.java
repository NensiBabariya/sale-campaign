package com.example.SaleCampaign.service;

import com.example.SaleCampaign.DTO.PricingHistoryDTO;
import com.example.SaleCampaign.DTO.ProductPricingHistoryResponse;
import com.example.SaleCampaign.model.PricingHistory;
import com.example.SaleCampaign.model.Product;
import com.example.SaleCampaign.repository.PricingHistoryRepo;
import com.example.SaleCampaign.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PricingHistoryService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private PricingHistoryRepo pricingHistoryRepo;

    public ProductPricingHistoryResponse getPricingHistory(long productId) {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        List<PricingHistory> historyEntities = pricingHistoryRepo.findByProductId(productId);

        List<PricingHistoryDTO> historyList = historyEntities.stream()
                .map(ph -> new PricingHistoryDTO(
                        ph.getOld_price(),
                        ph.getNew_price(),
                        ph.getReason(),
                        ph.getChange_date()
                ))
                .collect(Collectors.toList());

        return new ProductPricingHistoryResponse(
                product.getP_id(),
                product.getTitle(),
                product.getMrp(),
                historyList
        );
    }

}
