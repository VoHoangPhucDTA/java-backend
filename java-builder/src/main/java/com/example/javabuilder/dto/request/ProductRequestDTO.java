package com.example.javabuilder.dto.request;

import com.example.javabuilder.exception.ErrorCode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data // Tự động có getter,setter,toString,EqualAndHashcode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class ProductRequestDTO {
    @NotBlank(message = "PRODUCT_BLANK")
    String name;

    @Size(min = 10, message = "DESCRIPTION_INVLID")
    String description;

    @Positive(message = "PRICE_INVALID")
    BigDecimal price;

    String imageUrl;
}
