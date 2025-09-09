package com.example.SaleCampaign.DTO;

import com.example.SaleCampaign.model.Product;

public class ProductResponseDTO {
    private long id;
    private String title;
    private double mrp;
    private double finalPrice;
    private String discountText;
    private int inventoryCount;


    public ProductResponseDTO(long id, String title, double mrp, double finalPrice, String discountText, int inventoryCount) {
        this.id = id;
        this.title = title;
        this.mrp = mrp;
        this.finalPrice = finalPrice;
        this.discountText = discountText;
        this.inventoryCount = inventoryCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getDiscountText() {
        return discountText;
    }

    public void setDiscountText(String discountText) {
        this.discountText = discountText;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int inventoryCount) {
        this.inventoryCount = inventoryCount;
    }
}
