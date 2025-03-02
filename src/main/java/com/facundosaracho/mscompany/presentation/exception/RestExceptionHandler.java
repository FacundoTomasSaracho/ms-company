package com.facundosaracho.mscompany.presentation.exception;

import com.facundosaracho.mscompany.exception.BusinessException;
import com.facundosaracho.mscompany.exception.RestException;
import com.facundosaracho.mscompany.exception.RetrofitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.facundosaracho.mscompany.presentation.exception.ErrorCodes.GENERIC_ERROR;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        log.error("Exception: ", exception);
        return new ResponseEntity<>(
                new ErrorDto(GENERIC_ERROR.getCode(), GENERIC_ERROR.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RetrofitException.class)
    public ResponseEntity<ErrorDto> handleException(RestException restException, HttpStatus httpStatus) {
        return formResponse(restException, httpStatus);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorDto> handleException(BusinessException businessException, HttpStatus httpStatus) {
        return formResponse(businessException, httpStatus);
    }

    private ResponseEntity<ErrorDto> formResponse(RestException e, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorDto(e.getCode(), e.getMessage()), httpStatus);
    }

}


