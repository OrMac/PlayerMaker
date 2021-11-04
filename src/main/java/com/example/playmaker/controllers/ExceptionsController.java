package com.example.playmaker.controllers;

import com.example.playmaker.exceptions.WrongDataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {

    private Logger logger =  LoggerFactory.getLogger(ControllerImpl.class);


    @ExceptionHandler()
    public ResponseEntity handleMissingData(WrongDataException e){
        logger.info("handle WrongDataException",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
