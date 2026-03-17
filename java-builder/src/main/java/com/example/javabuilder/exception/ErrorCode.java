package com.example.javabuilder.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PRODUCT_NOT_EXISTED(1001, "Product not existed"),
    PRODUCT_EXISTED(1002, "Product existed"),
    PRODUCT_BLANK(1003, "Product must have name"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(9998, "Invalid key"),
    DESCRIPTION_INVALID(1004, "Description must be at least 10 characters"),
    PRICE_INVALID(1005, "Price must be higher than 0"),
    PASSWORD_BLANK(1006, "Password must not be blank"),
    UNAUTHENTICATED(1007, "Unauthenticated"),
    

    ;
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
