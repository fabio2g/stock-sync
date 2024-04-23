package com.github.fabio2g.stocksync.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.fabio2g.stocksync.enums.product.CategoryEnum;
import com.github.fabio2g.stocksync.enums.product.ColorEnum;
import com.github.fabio2g.stocksync.model.Supllier;

import java.time.Instant;
import java.util.List;

public record ProductDTO(
        String id,
        String name,
        String description,
        String reference,
        String barcode,
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
        String shippingCompany,
        List<Supllier> suplliers,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant createAt,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant updateAt
) {
    public static ProductDTO empty() {
        return new ProductDTO(
                null, null, null, null, null, null, null,
                0.0, 0.0, 0, 0, 0, 0, 0,
                null, null, null, null, null
        );
    }
}