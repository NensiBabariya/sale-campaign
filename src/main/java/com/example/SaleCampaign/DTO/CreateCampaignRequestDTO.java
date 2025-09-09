package com.example.SaleCampaign.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.util.List;

public class CreateCampaignRequestDTO {

    @NotNull(message = "start date is required")
    @FutureOrPresent(message = "Start date must be in future or today")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate start_date;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in future")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate end_date;

    @NotBlank(message = "Campaign name required")
    private String title;

    @NotNull(message = "At least one campaign discount required")
    @Valid
    private List<DiscountDTO> campaignDiscount;

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<DiscountDTO> getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(List<DiscountDTO> campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }
}
