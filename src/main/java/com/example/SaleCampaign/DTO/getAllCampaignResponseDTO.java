package com.example.SaleCampaign.DTO;


import java.time.LocalDate;
import java.util.List;

public class getAllCampaignResponseDTO {
    private long id;
    private  String title;
    private LocalDate start_date;
    private LocalDate end_date;
    private List<DiscountDTO> discountList;

    public getAllCampaignResponseDTO(long id, String title, LocalDate start_date, LocalDate end_date, List<DiscountDTO> discountDTOList) {
        this.id = id;
        this.title = title;
        this.start_date = start_date;
        this.end_date = end_date;
        this.discountList = discountDTOList;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
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

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public List<DiscountDTO> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(List<DiscountDTO> discountList) {
        this.discountList = discountList;
    }
}
