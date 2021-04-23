package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.dao.*;
import org.fimba.warehousemanagmentsystem.exception.DuplicateException;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockTransferDTO;
import org.fimba.warehousemanagmentsystem.model.dto.StockUpdateDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.fimba.warehousemanagmentsystem.service.TransferOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Date;


@Slf4j
@RequiredArgsConstructor
@Service
public class ProductWarehouseServiceImpl implements ProductWarehouseService {

    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final ProductCRUDRepository productCRUDRepository;
    private final ProductWarehouseRepository productWarehouseRepository;
    private final TransferOperationService transferOperationService;
    private final TransferOperationRepository transferOperationRepository;

    @Override
    public ResponseEntity<?> add(ProductWarehouseDTO dto) {

        boolean control = transferOperationService.isExist(dto.getProductId(), dto.getWarehouseId());

        if (control) {
            throw new DuplicateException("Product and Warehouse already exist");
        }

        // With the ID's taken from the user, we pull the objects from the database.
        WarehouseEntity warehouseEntity = warehouseCRUDRepository.findById(dto.getWarehouseId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Warehouse"));

        ProductEntity productEntity = productCRUDRepository.findById(dto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Product"));


        ProductWarehouseEntity productWarehouseEntity = new ProductWarehouseEntity();

        productWarehouseEntity.setStok(dto.getStok());
        productWarehouseEntity.setDate(new Date());
        productWarehouseEntity.setWarehouseEntity(warehouseEntity);
        productWarehouseEntity.setProductEntity(productEntity);


        productWarehouseRepository.save(productWarehouseEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    @Transactional
    public ResponseEntity<?> transfer(StockTransferDTO dto) {
        StockTransferDTO transferDTO = new StockTransferDTO();
        transferDTO.setToWarehouseId(dto.getToWarehouseId());
        transferDTO.setFromWarehouseId(dto.getFromWarehouseId());
        transferDTO.setProductId(dto.getProductId());

        boolean control = transferOperationService.isExist(transferDTO.getProductId(), transferDTO.getToWarehouseId());


        if (control) {

            ProductWarehouseEntity fromWarehouseEntity = transferOperationRepository.isExist(transferDTO.getProductId(), transferDTO.getFromWarehouseId());
            Long stok1 = fromWarehouseEntity.getStok();
            productWarehouseRepository.delete(fromWarehouseEntity);

            ProductWarehouseEntity toWarehouseEntity = transferOperationRepository.isExist(transferDTO.getProductId(), transferDTO.getToWarehouseId());
            Long stok2 = toWarehouseEntity.getStok();


            toWarehouseEntity.setStok(stok1 + stok2);
            productWarehouseRepository.save(toWarehouseEntity);


            return ResponseEntity.ok(HttpStatus.OK);
        }

        productWarehouseRepository.transfer(transferDTO.getToWarehouseId(), transferDTO.getFromWarehouseId(), transferDTO.getProductId());

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> update(StockUpdateDTO dto) {

        boolean control = transferOperationService.isExist(dto.getProductId(), dto.getWarehouseId());

        if (!control) {
            throw new ResourceNotFoundException("Not found warehouse and product");
        }

        ProductWarehouseEntity productWarehouseEntity =
                productWarehouseRepository.update(dto.getWarehouseId(), dto.getProductId());
        productWarehouseEntity.setStok(dto.getStock());


        productWarehouseRepository.save(productWarehouseEntity);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collection<?>> summaries() {
        Collection<?> productWarehouseEntity = productWarehouseRepository.findAllByProductWarehouse();
        log.info(productWarehouseEntity.toString());
        return ResponseEntity.ok().body(productWarehouseEntity);
    }

}
