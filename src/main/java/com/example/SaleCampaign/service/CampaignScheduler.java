package com.example.SaleCampaign.service;

import com.example.SaleCampaign.model.Campaign;
import com.example.SaleCampaign.model.CampaignDiscount;
import com.example.SaleCampaign.model.PricingHistory;
import com.example.SaleCampaign.model.Product;
import com.example.SaleCampaign.repository.CampaignDiscountRepo;
import com.example.SaleCampaign.repository.CampaignRepo;
import com.example.SaleCampaign.repository.PricingHistoryRepo;
import com.example.SaleCampaign.repository.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampaignScheduler {
    @Autowired
    ProductRepo productRepo;

    @Autowired
    CampaignRepo campaignRepo;

    @Autowired
    CampaignDiscountRepo campaignDiscountRepo;

    @Autowired
    PricingHistoryRepo pricingHistoryRepo;

    @Autowired
    CampaignService campaignService;

    @Scheduled(cron = "0 33 10 * * ?")
    public void runScheduledDiscountJob() {
        System.out.println("Starting scheduled discount job at==" + LocalDateTime.now());

        try {
            applyScheduledDiscounts();
            revertScheduledDiscounts();
        } catch (Exception e) {
            System.out.println("Error occurred while applying scheduled job " + e.getMessage());
        }
    }

    @Transactional
    public void revertScheduledDiscounts() {
        LocalDate today = LocalDate.now();

        List<Campaign> endedCampaigns = campaignRepo.findEndDateCampaigns(today);
        for (Campaign campaign : endedCampaigns) {
            System.out.println("ended campaigns::" + campaign.getC_id());
            List<CampaignDiscount> discounts = campaignDiscountRepo.findEligibleProductForDiscount(campaign.getC_id());

            for (CampaignDiscount cd : discounts) {
                Product product = cd.getProduct();

                // Recalculate base price from mrp and permanent discount
                double revertedPrice = product.getMrp() - (product.getMrp() * product.getDiscount() / 100.0);

                if (product.getCur_price() != revertedPrice) {
                    double oldPrice = product.getCur_price();

                    product.setCur_price(revertedPrice);
                    productRepo.save(product);

                    PricingHistory history = new PricingHistory(
                            oldPrice,
                            revertedPrice,
                            "Campaign Ended: " + campaign.getTitle(),
                            LocalDate.now(),
                            product
                    );
                    pricingHistoryRepo.save(history);

                }
            }
        }
    }

    @Transactional
    public void applyScheduledDiscounts() {
        List<Campaign> activeCampaigns = campaignRepo.findStartDateCampaign(LocalDate.now());
//        System.out.println("allProducts::" + id);

        for (Campaign campaign : activeCampaigns) {
            List<CampaignDiscount> discounts = campaignDiscountRepo.findEligibleProductForDiscount(campaign.getC_id());

            for (CampaignDiscount discount : discounts) {
                Product product = discount.getProduct();
                double oldPrice = product.getCur_price();

                double totalDiscount = discount.getDiscount() + product.getDiscount();
                double discountAmount = product.getMrp() * (totalDiscount / 100.0);
                double newPrice = product.getMrp() - discountAmount;

                if (product.getCur_price() != newPrice) {
                    product.setCur_price(newPrice);
                    productRepo.save(product);

                    PricingHistory pricingHistory = new PricingHistory(oldPrice, newPrice, "Campaign started: " + campaign.getTitle(), campaign.getStartDate(), product);
                    pricingHistoryRepo.save(pricingHistory);
                }
                System.out.println("Updated product " + product.getTitle() + " to " + newPrice);
            }
        }
    }


}
