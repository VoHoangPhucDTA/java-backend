package com.example.javabuilder.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PRODUCT_EXISTED(1002, "Product existed"),
    PRODUCT_BLANK(1003, "Product must have name"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error"),
    INVALID_KEY(1001, "Uncategorized error"),
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
