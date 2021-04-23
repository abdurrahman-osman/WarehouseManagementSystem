package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ProductWarehouseService{

    ResponseEntity<?> add(ProductWarehouseDTO dto);

    ResponseEntity<?> transfer(StockTransferDTO dto);

    ResponseEntity<?> update(StockUpdateDTO dto);

    ResponseEntity<Collection<?>> summaries();

}
