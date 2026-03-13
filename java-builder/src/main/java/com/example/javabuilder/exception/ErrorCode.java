package com.example.javabuilder.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PRODUCT_EXISTED(1002, "Product existed"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    DESCRIPTION_INVALID(1003, "Description must be at least 10 characters"),
    PRICE_INVALID(1004, "Price must be higher than 0")

    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
