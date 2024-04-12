package com.github.fabio2g.stocksync.repository;

import com.github.fabio2g.stocksync.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query
    Product findBySerie(String serie);
}
