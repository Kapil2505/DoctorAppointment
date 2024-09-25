package com.DoctorAppointment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionClass extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails>resourceNotFound(ResourceNotFound rs , WebRequest wb)
    {
        ErrorDetails er = new ErrorDetails(new Date(),rs.getMessage(),wb.getDescription(true));
        return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails>globalExceptionHandler(Exception exception,WebRequest wb)
    {
        ErrorDetails err = new ErrorDetails(new Date(),exception.getMessage(),wb.getDescription(true));
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
