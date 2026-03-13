package com.example.javabuilder.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)  // field nào null thì sẽ không kèm vào trong JSON
public class ApiResponse <T>{
    private int code = 1000;
    private String message;
    private T result;
}
