package com.example.SaleCampaign.model;


import jakarta.persistence.*;

@Entity
@Table(name = "campaign_discount")
public class CampaignDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long campaign_di_id;

    @ManyToOne
    @JoinColumn(name = "campaign_id", referencedColumnName = "c_id", nullable = false)
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product product;

    private int discount;


    public long getCampaign_di_id() {
        return campaign_di_id;
    }

    public void setCampaign_di_id(long campaign_di_id) {
        this.campaign_di_id = campaign_di_id;
    }

    public Campaign getCampaign() {
        return campaign;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
