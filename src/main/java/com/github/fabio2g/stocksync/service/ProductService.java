package com.github.fabio2g.stocksync.service;

import com.github.fabio2g.stocksync.dto.ProductDTO;
import com.github.fabio2g.stocksync.model.Product;
import com.github.fabio2g.stocksync.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO save(ProductDTO productDTO) {
        if (productRepository.findByReference(productDTO.reference()) != null) {
            return ProductDTO.empty();
        }


        Product entity = new Product(
                productDTO.name(),
                productDTO.description(),
                productDTO.reference(),
                productDTO.barcode(),
                productDTO.brand(),
                productDTO.color(),
                productDTO.purchasePrice(),
                productDTO.salePrice(),
                productDTO.profitMargin(),
                productDTO.stock(),
                productDTO.minStock(),
                productDTO.maxStock(),
                productDTO.category()
        );

        Product product = productRepository.save(entity);

        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getReference(),
                product.getBarcode(),
                product.getBrand(),
                product.getColor(),
                product.getPurchasePrice(),
                product.getSalePrice(),
                product.getProfitMargin(),
                product.getStock(),
                product.getMinStock(),
                product.getMaxStock(),
                product.getTotalSales(),
                product.getCategory(),
                product.getShippingCompany(),
                new ArrayList<>(product.getSuppliers()),
                product.getCreateAt(),
                product.getUpdateAt()
        );
    }
}
