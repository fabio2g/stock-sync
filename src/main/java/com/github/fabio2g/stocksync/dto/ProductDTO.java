package com.github.fabio2g.stocksync.dto;


import com.github.fabio2g.stocksync.enums.ProductCategoryEnum;

public record ProductDTO(
        String id,
        String title,
        String description,
        String serie,
        String brand,
        String color,
        double price,
        int stock,
        int sales,
        ProductCategoryEnum category
) {
}