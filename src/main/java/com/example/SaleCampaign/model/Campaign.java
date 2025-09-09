package com.example.SaleCampaign.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "campaign")

public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long c_id;

    private String title;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

//    @OneToMany(mappedBy = "campaign",cascade = CascadeType.ALL,orphanRemoval = true)
//    private List<CampaignDiscount> discountList;


    public long getC_id() {
        return c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

//    public List<CampaignDiscount> getDiscountList() {
//        return discountList;
//    }
//
//    public void setDiscountList(List<CampaignDiscount> discountList) {
//        this.discountList = discountList;
//    }
}
