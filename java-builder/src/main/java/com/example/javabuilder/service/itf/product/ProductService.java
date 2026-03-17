package com.example.javabuilder.service.itf.product;

import com.example.javabuilder.dto.request.ApiResponse;
import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;
import com.example.javabuilder.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequestDTO product);
    ProductResponseDTO getProductById(String id);
    List<Product> getAllProducts();
    void deleteProductById(String id);
    boolean existsByName(String name);
    ProductResponseDTO updateProduct(String id, ProductRequestDTO product);
}
