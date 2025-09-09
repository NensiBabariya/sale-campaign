package com.example.SaleCampaign.repository;

import com.example.SaleCampaign.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Long> {


    @Query(value = "SELECT * FROM campaign WHERE start_date =:today", nativeQuery = true)
    List<Campaign> findStartDateCampaign(LocalDate today);

    @Query(value = "SELECT * FROM campaign WHERE end_date < :today", nativeQuery = true)
    List<Campaign> findEndDateCampaigns(LocalDate today);


    @Query(value = "SELECT * FROM campaign WHERE start_date <= CURRENT_DATE AND end_date >= CURRENT_DATE", nativeQuery = true)
    List<Campaign> findPresentCampaigns();

    @Query(value = "SELECT * FROM campaign WHERE start_date > CURRENT_DATE", nativeQuery = true)
    List<Campaign> findUpComingCampaign();




}
