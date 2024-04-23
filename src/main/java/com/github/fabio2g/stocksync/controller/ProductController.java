package com.github.fabio2g.stocksync.controller;

import com.github.fabio2g.stocksync.dto.ProductDTO;
import com.github.fabio2g.stocksync.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO) {
        ProductDTO productResponse = productService.save(productDTO);

        if(productResponse.id() == null) {
            return ResponseEntity.badRequest().body(productResponse);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }
}
