package com.github.fabio2g.stocksync.service;

import com.github.fabio2g.stocksync.dto.ProductDTO;
import com.github.fabio2g.stocksync.model.Product;
import com.github.fabio2g.stocksync.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDTO save(ProductDTO productDTO) {
        if (productRepository.findBySerie(productDTO.serie()) != null) {
            return null;
        }

        Product entity = new Product();

        return null;
    }
}
