package com.example.SaleCampaign.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pricing_history")

public class PricingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pricing_id;

    private double old_price;
    private double new_price;
    private String reason;

    private LocalDate change_date;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "p_id")
    private Product product;

    public PricingHistory() {
    }

    public PricingHistory(double old_price, double new_price, String reason, LocalDate change_date, Product product) {
        this.old_price = old_price;
        this.new_price = new_price;
        this.reason = reason;
        this.change_date = change_date;
        this.product = product;
    }

    public long getPricing_id() {
        return pricing_id;
    }

    public void setPricing_id(long pricing_id) {
        this.pricing_id = pricing_id;
    }

    public double getOld_price() {
        return old_price;
    }

    public void setOld_price(double old_price) {
        this.old_price = old_price;
    }

    public double getNew_price() {
        return new_price;
    }

    public void setNew_price(double new_price) {
        this.new_price = new_price;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getChange_date() {
        return change_date;
    }

    public void setChange_date(LocalDate change_date) {
        this.change_date = change_date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
