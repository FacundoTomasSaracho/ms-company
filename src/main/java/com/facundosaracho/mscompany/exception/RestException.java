package com.facundosaracho.mscompany.exception;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class RestException extends RuntimeException {

    private final Integer code;
    private final String message;
    private final HttpStatus httpStatus;

    public RestException(ExceptionCode exceptionCode, HttpStatus httpStatus) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
        this.httpStatus = httpStatus;
    }

}
