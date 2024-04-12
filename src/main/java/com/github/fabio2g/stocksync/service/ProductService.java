package com.github.fabio2g.stocksync.service;

import com.github.fabio2g.stocksync.dto.ProductDTO;
import com.github.fabio2g.stocksync.exception.ProductException;
import com.github.fabio2g.stocksync.model.Product;
import com.github.fabio2g.stocksync.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public ProductDTO save(ProductDTO productDTO) {
        if (productRepository.findBySerie(productDTO.serie()) != null) {
            throw new ProductException("Erro no cadastro: O produto com número de série '" + productDTO.serie() + "' já está cadastrado.");
        }

        Product entity = new Product(
                productDTO.title(),
                productDTO.description(),
                productDTO.serie(),
                productDTO.brand(),
                productDTO.color(),
                productDTO.price(),
                productDTO.stock(),
                productDTO.sales(),
                productDTO.category()
        );

        Product newProduct = productRepository.save(entity);

        return new ProductDTO(
                newProduct.getId(),
                newProduct.getTitle(),
                newProduct.getDescription(),
                newProduct.getSerie(),
                newProduct.getBrand(),
                newProduct.getColor(),
                newProduct.getPrice(),
                newProduct.getStock(),
                newProduct.getSales(),
                newProduct.getCategory()
        );
    }
}
