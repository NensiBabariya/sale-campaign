package com.example.SaleCampaign.DTO;

import java.time.LocalDate;

public class PricingHistoryDTO {
    private double oldPrice;
    private double newPrice;
    private String reason;
    private LocalDate changeDate;

    public PricingHistoryDTO(double oldPrice, double newPrice, String reason, LocalDate changeDate) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.reason = reason;
        this.changeDate = changeDate;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(double newPrice) {
        this.newPrice = newPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }
}
