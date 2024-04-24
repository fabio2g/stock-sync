package com.github.fabio2g.stocksync.service;

import com.github.fabio2g.stocksync.dto.ProductDTO;
import com.github.fabio2g.stocksync.model.Product;
import com.github.fabio2g.stocksync.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDTO save(ProductDTO productDTO) {
        if (productRepository.findByReference(productDTO.reference()) != null) {
            return ProductDTO.empty();
        }

        String barcode = BarcodeGenerator.generateBarcode(productDTO.reference());

        Product entity = new Product(
                productDTO.name(),
                productDTO.description(),
                productDTO.reference(),
                barcode,
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
        return convertToDTO(product);
    }

    public List<ProductDTO> findAll() {

        List<Product> products = productRepository.findAll();

        List<ProductDTO> productDTOS = products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return productDTOS;
    }

    public ProductDTO findById(String id) {
        Optional<Product> product = productRepository.findById(id);

        return convertToDTO(product.get());
    }


    public void printBarcodeImage(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()) {
            throw new RuntimeException("Produto não encontrado para o ID: " + productId);
        }

        Product product = productOptional.get();

        if (product.getBarcode() == null || product.getBarcode().isEmpty()) {
            throw new RuntimeException("O produto com ID " + productId + " não possui um código de barras.");
        }

        BarcodeGenerator.generateImageBarcode(product.getReference(), product.getBarcode());
    }

    private ProductDTO convertToDTO(Product product) {
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
