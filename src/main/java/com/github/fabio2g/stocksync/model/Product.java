package com.github.fabio2g.stocksync.model;

import com.github.fabio2g.stocksync.enums.CategoryEnum;
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
    private String title;
    private String description;
    private String serie;
    private String brand;
    private String color;
    private double price;
    private int stock;
    private int sales;
    private CategoryEnum category;
    private Instant createAt;
    private Instant updateAt;

    public Product(
            String title,
            String description,
            String serie,
            String brand,
            String color,
            double price,
            int stock,
            int sales,
            CategoryEnum category,
            Instant createAt,
            Instant updateAt
    ) {
        this.title = title;
        this.description = description;
        this.serie = serie;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.category = category;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
}
