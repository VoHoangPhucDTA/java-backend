package com.example.javabuilder.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Instant;

@Data // Tự động có getter,setter,toString,EqualAndHashcode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDTO {
    String id;
    String name;
    String description;
    BigDecimal price;
    String imageUrl;

}
