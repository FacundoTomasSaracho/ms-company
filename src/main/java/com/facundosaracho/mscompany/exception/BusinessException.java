package com.facundosaracho.mscompany.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RestException{
    public BusinessException(ExceptionCode exceptionCode, HttpStatus httpStatus) {
        super(exceptionCode, httpStatus);
    }
}
