package com.example.SaleCampaign.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class DiscountDTO {

    @NotNull(message = "Product id is required")
    private long product_id;

    @NotNull(message = "Discount is  required")
    @Positive(message = "Discount must be positive")
    private int discount;


    public DiscountDTO(long product_id, int discount) {
        this.product_id = product_id;
        this.discount = discount;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
