//package com.Classroom.Lighthouse.Classroom.Exception;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
//        // Handle validation errors and construct an appropriate ErrorResponse
//        return new ErrorResponse("Validation Error", ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//    }
//
//    @ExceptionHandler(EntityNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse handleEntityNotFoundException(EntityNotFoundException ex) {
//        // Handle entity not found errors and construct an appropriate ErrorResponse
//        return new ErrorResponse("Entity Not Found", ex.getMessage());
//    }
//
//    // Add more exception handlers as needed...
//}



