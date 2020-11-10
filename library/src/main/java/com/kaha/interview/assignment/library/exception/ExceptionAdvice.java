package com.kaha.interview.assignment.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.kaha.interview.assignment.library.dto.ResponseDto;

@RestControllerAdvice
public class ExceptionAdvice {

	@ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleExceptions( CustomException exception, WebRequest webRequest) {
        ResponseDto response = new ResponseDto();
        ResponseEntity<Object> entity;
        response.setStatus("Error");
        if(exception.getMessage() == "Exists") {
        	response.setMessage("Record allready exists!");
        	entity = new ResponseEntity<>(response,HttpStatus.CONFLICT);
        }else if(exception.getMessage() != "") {
        	response.setMessage(exception.getMessage());
        	entity = new ResponseEntity<>(response,HttpStatus.OK);
        }else {
        	response.setMessage("Some Error Happened");
        	entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        
        return entity;
    }
}
