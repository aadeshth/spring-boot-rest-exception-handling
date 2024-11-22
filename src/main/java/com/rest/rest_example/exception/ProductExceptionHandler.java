package com.rest.rest_example.exception;


import com.rest.rest_example.model.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> productNotFoundException(ProductNotFoundException e)
    {
        return new ResponseEntity<>(ProductResponse.builder().error(e.getMessage()).status(HttpStatus.NOT_FOUND.name()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException e)
    {
        return new ResponseEntity<>(ProductResponse.builder().error(e.getMessage()).status(HttpStatus.INTERNAL_SERVER_ERROR.name()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
