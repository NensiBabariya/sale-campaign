package com.example.SaleCampaign.DTO;

import java.util.List;

public class ProductPricingHistoryResponse {

    private long productId;
    private String title;
    private double mrp;
    private List<PricingHistoryDTO> history;

    public ProductPricingHistoryResponse(long productId, String title, double mrp, List<PricingHistoryDTO> history) {
        this.productId = productId;
        this.title = title;
        this.mrp = mrp;
        this.history = history;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public List<PricingHistoryDTO> getHistory() {
        return history;
    }

    public void setHistory(List<PricingHistoryDTO> history) {
        this.history = history;
    }
}
