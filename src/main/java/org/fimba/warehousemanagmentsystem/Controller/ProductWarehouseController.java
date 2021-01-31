package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/productwarehouse")
public class ProductWarehouseController {

    private final ProductWarehouseService productWarehouseService;
    @GetMapping
    public WarehouseAPIResponseHolder<Collection<ProductWarehouse>> getAll(){
        return null;
    }
    @PostMapping
    public WarehouseAPIResponseHolder<ProductWarehouseDTO> add(@RequestBody ProductWarehouseDTO productWarehouseDTO){


           return productWarehouseService.add(productWarehouseDTO);
    }

}
