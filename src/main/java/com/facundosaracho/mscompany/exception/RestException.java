package com.facundosaracho.mscompany.exception;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestException extends RuntimeException {

    private Integer code;
    private String message;

    public RestException(ExceptionCode exceptionCode) {
        this.code = exceptionCode.getCode();
        this.message = exceptionCode.getMessage();
    }

}
