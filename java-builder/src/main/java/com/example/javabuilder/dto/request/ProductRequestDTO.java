package com.example.javabuilder.dto.request;

import com.example.javabuilder.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDTO {
    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Size(min = 10, message = "DESCRIPTION_INVALID")
    private String description;

    @Positive(message = "PRICE_INVALID")
    private BigDecimal price;

    private String imageUrl;
}
