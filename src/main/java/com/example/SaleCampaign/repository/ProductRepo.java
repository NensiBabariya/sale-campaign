package com.example.SaleCampaign.repository;

import com.example.SaleCampaign.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT * FROM campaign WHERE start_date <= CURRENT_DATE AND end_date >= CURRENT_DATE", nativeQuery = true)
//    List<Product> findEligibleProductForDiscount();
}
