package com.fimba.WarehouseManagmentSystem.Controller;

import com.fimba.WarehouseManagmentSystem.Model.Dto.WarehouseDTO;
import com.fimba.WarehouseManagmentSystem.Response.ResponseHolder;
import com.fimba.WarehouseManagmentSystem.Service.WarehouseService.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;


    @GetMapping
    public ResponseHolder<Collection<WarehouseDTO>> getAllActiveWarehouses(){
        return warehouseService.list();
    }
    @PostMapping
    public ResponseHolder<WarehouseDTO> create(@RequestBody @Valid WarehouseDTO warehouseDTO){

        return warehouseService.create(warehouseDTO);
    }
    @PutMapping
    public ResponseHolder<WarehouseDTO> update(@RequestBody @Valid WarehouseDTO warehouseDTO){
        return warehouseService.update(warehouseDTO);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
