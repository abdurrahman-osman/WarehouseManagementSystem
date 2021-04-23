package org.fimba.warehousemanagmentsystem.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class WarehouseAPIExceptionHandler{

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<?> DuplicateException(DuplicateException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError("DUPLICATE_DATA",
                        exception.getMessage());
        return new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ExceptionHandlingResourceNotFound(ResourceNotFoundException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError("NOT_FOUND",
                        exception.getMessage());
        return new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> ExceptionHandlingValidation(MethodArgumentNotValidException exception){
        WarehouseAPIResponseError warehouseAPIResponseError =
                new WarehouseAPIResponseError("VALIDATION_ERROR",
                        exception.getBindingResult().getFieldError().getDefaultMessage());

        return  new ResponseEntity<>(warehouseAPIResponseError,HttpStatus.BAD_REQUEST);
    }
}
