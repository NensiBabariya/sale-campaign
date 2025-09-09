package com.example.SaleCampaign.DTO;

import com.example.SaleCampaign.model.Product;

import java.util.List;

public class PaginatedResponseDTO<Product> {
    private List<Product> products;
    private int pageNumber;
    private int pageSize;
    private int totalPages;


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
