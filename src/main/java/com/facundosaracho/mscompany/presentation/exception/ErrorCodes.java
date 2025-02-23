package com.facundosaracho.mscompany.presentation.exception;

import lombok.Getter;

@Getter
public enum ErrorCodes {

    GENERIC_ERROR(5000, "GENERIC ERROR");

    private final Integer code;
    private final String message;

     ErrorCodes(Integer code, String message){
         this.code = code;
         this.message = message;
     }
}