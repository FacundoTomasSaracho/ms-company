package com.facundosaracho.mscompany.exception;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    RETROFIT_EXCEPTION(5000, "Retrofit exception"),
    NO_COMPANIES_WERE_FOUND(4000, "No companies were found.");

    private final Integer code;
    private final String message;

    ExceptionCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
