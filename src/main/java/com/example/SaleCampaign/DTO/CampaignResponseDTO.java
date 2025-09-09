package com.example.SaleCampaign.DTO;

import com.example.SaleCampaign.model.Campaign;

import java.util.List;

public class CampaignResponseDTO {

    List<getAllCampaignResponseDTO> pastCampaign;
    List<getAllCampaignResponseDTO> currentCampaign;
    List<getAllCampaignResponseDTO> futureCampaign;

    public CampaignResponseDTO(List<getAllCampaignResponseDTO> pastCampaign, List<getAllCampaignResponseDTO> currentCampaign, List<getAllCampaignResponseDTO> futureCampaign) {
        this.pastCampaign = pastCampaign;
        this.currentCampaign = currentCampaign;
        this.futureCampaign = futureCampaign;
    }

    public List<getAllCampaignResponseDTO> getPastCampaign() {
        return pastCampaign;
    }

    public void setPastCampaign(List<getAllCampaignResponseDTO> pastCampaign) {
        this.pastCampaign = pastCampaign;
    }

    public List<getAllCampaignResponseDTO> getCurrentCampaign() {
        return currentCampaign;
    }

    public void setCurrentCampaign(List<getAllCampaignResponseDTO> currentCampaign) {
        this.currentCampaign = currentCampaign;
    }

    public List<getAllCampaignResponseDTO> getFutureCampaign() {
        return futureCampaign;
    }

    public void setFutureCampaign(List<getAllCampaignResponseDTO> futureCampaign) {
        this.futureCampaign = futureCampaign;
    }
}
