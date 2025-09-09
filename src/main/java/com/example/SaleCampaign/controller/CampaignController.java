package com.example.SaleCampaign.controller;


import com.example.SaleCampaign.DTO.AddProductResponseDTO;
import com.example.SaleCampaign.DTO.CampaignResponseDTO;
import com.example.SaleCampaign.DTO.CreateCampaignRequestDTO;
import com.example.SaleCampaign.model.Campaign;
import com.example.SaleCampaign.service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("campaigns")
public class CampaignController {

    @Autowired
    CampaignService campaignService;


    @PostMapping
    public AddProductResponseDTO saveCampaigns(@RequestBody CreateCampaignRequestDTO campaign) {
        return campaignService.saveCampaign(campaign);
    }

    @GetMapping("get-all-campaigns")
    public CampaignResponseDTO getAllCampaign(){
        return campaignService.getAllCampaigns();
    }

}
