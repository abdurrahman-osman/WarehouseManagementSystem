package org.fimba.warehousemanagmentsystem.exception;

import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class WarehouseAPIExceptionHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ExceptionHandlingValidation(MethodArgumentNotValidException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError(exception.getBindingResult().getObjectName(),
                        exception.getBindingResult().getFieldError().getDefaultMessage());

        return  new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.BAD_REQUEST);
    }
}
