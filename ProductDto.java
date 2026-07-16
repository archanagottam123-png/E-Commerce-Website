package com.example.ecommerce.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private String brand;
    private double price;
    private double discount;
    private int stockQuantity;
    private String imageUrl;
    private double rating;
    private Long categoryId;
}
