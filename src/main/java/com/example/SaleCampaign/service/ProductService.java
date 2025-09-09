package com.example.SaleCampaign.service;

import com.example.SaleCampaign.DTO.AddProductResponseDTO;
import com.example.SaleCampaign.DTO.PaginatedResponseDTO;
import com.example.SaleCampaign.DTO.ProductResponseDTO;
import com.example.SaleCampaign.model.Product;
import com.example.SaleCampaign.repository.CampaignDiscountRepo;
import com.example.SaleCampaign.repository.CampaignRepo;
import com.example.SaleCampaign.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CampaignDiscountRepo campaignDiscountRepo;


    public AddProductResponseDTO addProducts(List<Product> product) {

        try {
            productRepo.saveAll(product);
            return new AddProductResponseDTO("All product added successfully", true);
        } catch (Exception e) {
            return new AddProductResponseDTO(e.getMessage(), false);
        }
    }

    public PaginatedResponseDTO<Product> getProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Product> productPage = productRepo.findAll(pageable);

        PaginatedResponseDTO<Product> response = new PaginatedResponseDTO<>();
        response.setProducts(productPage.getContent());
        response.setPageNumber(productPage.getNumber());
        response.setPageSize(productPage.getSize());
        response.setTotalPages(productPage.getTotalPages());

        return response;
    }

    public List<ProductResponseDTO> getAllProducts() {

        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

        List<Product> products = productRepo.findAll();

        for (Product p : products) {

            double campaignDiscount = campaignDiscountRepo.findActiveDiscountForProduct(p.getP_id()).orElse(0.0);
            System.out.println("campaignDis=====" + campaignDiscount);
//            double finalDiscountPercent =campaignDiscount;
            double finalPrice = p.getCur_price() - (p.getCur_price() * campaignDiscount / 100.0);

            double finalDiscountPercent = p.getDiscount() + campaignDiscount;
//            double finalPrice = p.getMrp() - (p.getMrp() * finalDiscountPercent / 100.0);

            ProductResponseDTO dto = new ProductResponseDTO(
                    p.getP_id(),
                    p.getTitle(),
                    p.getMrp(),
                    finalPrice,
                    finalDiscountPercent + "% Off",
                    p.getInventory_count()
            );

            productResponseDTOList.add(dto);
        }

        return productResponseDTOList;
    }
}
