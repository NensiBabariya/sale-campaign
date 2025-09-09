package com.example.SaleCampaign.repository;

import com.example.SaleCampaign.model.CampaignDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignDiscountRepo extends JpaRepository<CampaignDiscount, Long> {

    @Query(value = "SELECT * FROM campaign_discount WHERE campaign_id=:id", nativeQuery = true)
    List<CampaignDiscount> findEligibleProductForDiscount(long id);

    @Query(value = """
    SELECT cd.discount 
    FROM campaign_discount cd
    JOIN campaign c ON cd.campaign_id = c.c_id
    WHERE cd.p_id = :productId
      AND c.start_date <= CURRENT_DATE
      AND c.end_date >= CURRENT_DATE
    LIMIT 1
    """, nativeQuery = true)
    Optional<Double> findActiveDiscountForProduct(long productId);



}
