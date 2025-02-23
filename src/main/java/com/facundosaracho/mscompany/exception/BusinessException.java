package com.facundosaracho.mscompany.exception;

public class BusinessException extends RestException{
    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
