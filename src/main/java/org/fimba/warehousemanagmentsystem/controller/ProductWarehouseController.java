package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouseapi/productwarehouse/transfer")
public class ProductWarehouseController {

    private final ProductWarehouseService productWarehouseService;

    @GetMapping
    public ResponseEntity<?> summaries() {
        return productWarehouseService.summaries();

    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductWarehouseDTO dto) {
        return  productWarehouseService.add(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody StockUpdateDTO dto) {
        return  productWarehouseService.update(dto);
    }

    @PutMapping("/product")
    public ResponseEntity<?> transfer(@RequestBody StockTransferDTO dto) {
        return productWarehouseService.transfer(dto);
    }

}
