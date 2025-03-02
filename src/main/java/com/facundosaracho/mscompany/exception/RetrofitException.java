package com.facundosaracho.mscompany.exception;

import org.springframework.http.HttpStatus;

public class RetrofitException extends RestException{
    public RetrofitException(ExceptionCode exceptionCode, HttpStatus httpStatus) {
        super(exceptionCode, httpStatus);
    }
}
