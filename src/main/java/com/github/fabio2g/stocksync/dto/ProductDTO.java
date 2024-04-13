package com.github.fabio2g.stocksync.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.fabio2g.stocksync.enums.product.CategoryEnum;
import com.github.fabio2g.stocksync.enums.product.ColorEnum;

import java.time.Instant;

public record ProductDTO(
        String id,
        String name,
        String description,
        String reference,
        String codebar,
        String brand,
        ColorEnum color,
        double purchasePrice,
        double salePrice,
        float profitMargin,
        int stock,
        int minStock,
        int maxStock,
        int sales,
        CategoryEnum category,
        String supplier,
        String shippingCompany,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant createAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant updateAt
) {
}