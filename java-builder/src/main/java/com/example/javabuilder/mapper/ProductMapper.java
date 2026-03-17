package com.example.javabuilder.mapper;

import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;
import com.example.javabuilder.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequestDTO request);
    ProductResponseDTO toProductResponse(Product product);
    void updateProduct(@MappingTarget Product product, ProductRequestDTO request);
}
