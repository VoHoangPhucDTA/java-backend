package com.example.javabuilder.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)  // field nào null thì sẽ không kèm vào trong JSON
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse <T>{
    @Builder.Default
    int code = 1000;
    String message;
    T result;
}
