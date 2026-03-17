package com.example.javabuilder.service.itf;

import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO product);
    ProductResponseDTO getProductById(String id);
    List<ProductResponseDTO> getAllProducts();
    void deleteProductById(String id);
    boolean existsByName(String name);
    ProductResponseDTO updateProduct(String id, ProductRequestDTO product);
}
