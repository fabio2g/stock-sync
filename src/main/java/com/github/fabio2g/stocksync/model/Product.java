package com.github.fabio2g.stocksync.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.fabio2g.stocksync.enums.product.CategoryEnum;
import com.github.fabio2g.stocksync.enums.product.ColorEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private String reference;
    private String codebar;
    private String brand;
    private ColorEnum color;
    private double purchasePrice;
    private double salePrice;
    private float profitMargin;
    private int stock;
    private int minStock;
    private int maxStock;
    private int totalSales;
    private CategoryEnum category;
    private String supplier;
    private String shippingCompany;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createAt;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant updateAt;

    public Product(String name, String description, String reference, String codebar, String brand, ColorEnum color, double purchasePrice, double salePrice, float profitMargin, int stock, int minStock, int maxStock, CategoryEnum category) {
        this.name = name;
        this.description = description;
        this.reference = reference;
        this.codebar = codebar;
        this.brand = brand;
        this.color = color;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.profitMargin = profitMargin;
        this.stock = stock;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.category = category;
    }
}
