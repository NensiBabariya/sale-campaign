package com.example.SaleCampaign.repository;

import com.example.SaleCampaign.model.PricingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PricingHistoryRepo extends JpaRepository<PricingHistory, Long> {
    @Query("SELECT ph FROM PricingHistory ph WHERE ph.product.p_id = :productId ORDER BY ph.change_date DESC")
    List<PricingHistory> findByProductId(@Param("productId") long productId);

}
