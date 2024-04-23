package com.github.fabio2g.stocksync.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.fabio2g.stocksync.enums.product.CategoryEnum;
import com.github.fabio2g.stocksync.enums.product.ColorEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
    private String barcode;
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
    private String shippingCompany;

    @CreationTimestamp
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant createAt;

    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant updateAt;

    @ManyToMany
    @JoinTable(
            name = "product_supplier",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supllier> suppliers = new ArrayList<>();

    public Product(String name, String description, String reference, String barcode, String brand,
                   ColorEnum color, double purchasePrice, double salePrice, float profitMargin, int stock,
                   int minStock, int maxStock, CategoryEnum category
    ) {
        this.name = name;
        this.description = description;
        this.reference = reference;
        this.barcode = barcode;
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
