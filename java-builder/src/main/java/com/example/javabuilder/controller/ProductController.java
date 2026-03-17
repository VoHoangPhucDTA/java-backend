package com.example.javabuilder.controller;

import com.example.javabuilder.dto.request.ApiResponse;
import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;
import com.example.javabuilder.model.Product;
import com.example.javabuilder.service.itf.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/products")
    public ApiResponse<Product> createProduct(@Valid @RequestBody ProductRequestDTO product) {
        ApiResponse<Product> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(product));
        return apiResponse;
    }

    @GetMapping("/products")
    public ApiResponse<List<Product>> getAllProducts() {
        ApiResponse<List<Product>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProducts());
        return apiResponse;
    }

    @GetMapping("/products/{id}")
    public ApiResponse<ProductResponseDTO> getProductById(@PathVariable String id) {
        ApiResponse<ProductResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getProductById(id));
        return apiResponse;
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
