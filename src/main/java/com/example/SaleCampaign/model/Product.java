package com.example.SaleCampaign.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long p_id;
    private String title;
    private double mrp;
    private double cur_price;
    private int discount;
    private int inventory_count;

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
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

    public double getCur_price() {
        return cur_price;
    }

    public void setCur_price(double cur_price) {
        this.cur_price = cur_price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getInventory_count() {
        return inventory_count;
    }

    public void setInventory_count(int inventory_count) {
        this.inventory_count = inventory_count;
    }
}
