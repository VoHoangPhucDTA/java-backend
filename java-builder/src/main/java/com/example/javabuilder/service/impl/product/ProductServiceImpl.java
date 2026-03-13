package com.example.javabuilder.service.impl.product;

import com.example.javabuilder.dto.request.ProductRequestDTO;
import com.example.javabuilder.exception.AppException;
import com.example.javabuilder.exception.ErrorCode;
import com.example.javabuilder.model.Product;
import com.example.javabuilder.repository.ProductRepository;
import com.example.javabuilder.service.itf.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequestDTO dto) {
        if (productRepository.existsByName(dto.getName())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .imageUrl(dto.getImageUrl())
                .build();

        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_EXISTED));
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


}
