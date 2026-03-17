package com.example.javabuilder.controller;

import com.example.javabuilder.dto.request.ApiResponse;
import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;
import com.example.javabuilder.service.itf.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ApiResponse<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO product) {
        return ApiResponse.<ProductResponseDTO>builder()
                .result(productService.createProduct(product))
                .build();
    }

    @GetMapping("/products")
    public ApiResponse<List<ProductResponseDTO>> getAllProducts() {
        return ApiResponse.<List<ProductResponseDTO>>builder()
                .result(productService.getAllProducts())
                .build();
    }

    @GetMapping("/products/{id}")
    public ApiResponse<ProductResponseDTO> getProductById(@PathVariable String id) {
        return ApiResponse.<ProductResponseDTO>builder()
                .result(productService.getProductById(id))
                .build();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable String id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/products/{id}")
    public ProductResponseDTO updateProduct(@PathVariable String id, ProductRequestDTO request) {
        return productService.updateProduct(id, request);
    }

}
