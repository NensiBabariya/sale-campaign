package com.example.SaleCampaign.service;

import com.example.SaleCampaign.DTO.*;
import com.example.SaleCampaign.model.Campaign;
import com.example.SaleCampaign.model.CampaignDiscount;
import com.example.SaleCampaign.model.Product;
import com.example.SaleCampaign.repository.CampaignDiscountRepo;
import com.example.SaleCampaign.repository.CampaignRepo;
import com.example.SaleCampaign.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    @Autowired
    CampaignRepo campaignRepo;

    @Autowired
    CampaignDiscountRepo campaignDiscountRepo;

    @Autowired
    ProductRepo productRepo;

    @Transactional
    public AddProductResponseDTO saveCampaign(CreateCampaignRequestDTO campaign) {
        try {

            Campaign campaign1 = new Campaign();
            System.out.println("start==" + campaign.getStart_date());
            campaign1.setStartDate(campaign.getStart_date());
            campaign1.setEndDate(campaign.getEnd_date());
            campaign1.setTitle(campaign.getTitle());
            campaignRepo.save(campaign1);


            List<DiscountDTO> discountList = campaign.getCampaignDiscount();
            for (int i = 0; i < discountList.size(); i++) {
                Product product = productRepo.findById(discountList.get(i).getProduct_id()).orElseThrow(() -> new RuntimeException("Product not found"));

                if (product == null) {
                    throw new RuntimeException("Product Not Found");
                }
                CampaignDiscount campaignDiscount = new CampaignDiscount();
                campaignDiscount.setDiscount(discountList.get(i).getDiscount());
                campaignDiscount.setProduct(product);
                campaignDiscount.setCampaign(campaign1);
                campaignDiscountRepo.save(campaignDiscount);
            }
            return new AddProductResponseDTO("save", true);
        } catch (Exception e) {
            return new AddProductResponseDTO(e.getMessage(), false);
        }
    }

    public CampaignResponseDTO getAllCampaigns() {

        List<Campaign> past = campaignRepo.findEndDateCampaigns(LocalDate.now());
        List<Campaign> present = campaignRepo.findPresentCampaigns();
        List<Campaign> future = campaignRepo.findUpComingCampaign();

        return new CampaignResponseDTO(
                mapToDTOList(past),
                mapToDTOList(present),
                mapToDTOList(future)
        );
    }

    private List<getAllCampaignResponseDTO> mapToDTOList(List<Campaign> campaigns) {
        return campaigns.stream().map(c -> {
            // ✅ fetch discounts for this campaign from repository
            List<CampaignDiscount> discounts = campaignDiscountRepo.findEligibleProductForDiscount(c.getC_id());

            List<DiscountDTO> discountDTOs = discounts.stream()
                    .map(cd -> new DiscountDTO(cd.getProduct().getP_id(), cd.getDiscount()))
                    .collect(Collectors.toList());

            return new getAllCampaignResponseDTO(
                    c.getC_id(),
                    c.getTitle(),
                    c.getStartDate(),
                    c.getEndDate(),
                    discountDTOs
            );
        }).collect(Collectors.toList());
    }

}
