package com.example.javabuilder.service.impl.product;

import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.dto.response.ProductResponseDTO;
import com.example.javabuilder.exception.AppException;
import com.example.javabuilder.exception.ErrorCode;
import com.example.javabuilder.mapper.ProductMapper;
import com.example.javabuilder.model.Product;
import com.example.javabuilder.repository.ProductRepository;
import com.example.javabuilder.service.itf.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product createProduct(ProductRequestDTO dto) {
        if (productRepository.existsByName(dto.getName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }
        Product product = productMapper.toProduct(dto);
        productRepository.save(product);
        return product;
    }

    @Override
    public ProductResponseDTO getProductById(String id) {
        return productMapper.toProductResponse(productRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Product not found")));
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepository.findAll();
    }

    @Override
    public void deleteProductById(String id) {
        if (getProductById(id) != null) productRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        // Giả sử để bắt exception chứ sản phẩm có thể trùng tên
        if (productRepository.existsByName(name)) throw new RuntimeException("tên sản phầm đã tồn tại");
        return false;
    }

    public ProductResponseDTO updateProduct(String productId, ProductRequestDTO request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productMapper.updateProduct(product,request);
        return productMapper.toProductResponse(productRepository.save(product));
    }


}
