package com.api.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.servlet.NoHandlerFoundException;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();

    @Test
    void testHandleBadRequestException() {
        MissingServletRequestParameterException exception = new MissingServletRequestParameterException("paramName", "paramType");

        ResponseEntity<String> response = exceptionHandler.handleBadRequestException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("error 400: Required request parameter 'paramName' for method parameter type paramType is not present", response.getBody());
    }

    @Test
    void testHandleNoResourceFoundException() {
        NoHandlerFoundException exception = new NoHandlerFoundException("GET", "/api/food", null);

        ResponseEntity<Object> response = exceptionHandler.handleNoResourceFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("ERROR 404: No endpoint GET /api/food.", response.getBody());
    }

    @Test
    void testHandleMethodNotSupportedException() {
        HttpRequestMethodNotSupportedException exception = new HttpRequestMethodNotSupportedException("POST");

        ResponseEntity<Object> response = exceptionHandler.handleMethodNotSupportedException(exception);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, response.getStatusCode());
        assertEquals("ERROR 405: Request method 'POST' is not supported", response.getBody());
    }



    @Test
    void testHandleAllExceptions() {
        RuntimeException exception = new RuntimeException("Something went wrong");

        ResponseEntity<Object> response = exceptionHandler.handleAllExceptions(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("ERROR 500: Something went wrong", response.getBody());
    }

    @Test
    void testHandleException() {
        Exception exception = new Exception("Internal server error");

        ResponseEntity<Object> response = exceptionHandler.handleException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Internal server error: Internal server error", response.getBody());
    }
}