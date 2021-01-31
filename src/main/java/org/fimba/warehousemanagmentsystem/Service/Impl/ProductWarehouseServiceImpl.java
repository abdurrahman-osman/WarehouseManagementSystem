package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.ProductWarehouseRepository;
import org.fimba.warehousemanagmentsystem.dao.UserCRUDRepository;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.fimba.warehousemanagmentsystem.service.ProductWarehouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductWarehouseServiceImpl implements ProductWarehouseService {
    private final ProductWarehouseRepository productWarehouseRepository;
    private final ProductCRUDRepository productCRUDRepository;
    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final UserCRUDRepository userCRUDRepository;
    private final EntityManager em;

    @Override
    @Transactional
        public WarehouseAPIResponseHolder<ProductWarehouseDTO> add(ProductWarehouseDTO productWarehouseDTO){
            productWarehouseDTO.setTransactionDate(new Date());
          ProductWarehouse productWarehouse = new ProductWarehouse();

          productWarehouse.setProduct(productCRUDRepository.getOne(productWarehouseDTO.getProductId()));
          productWarehouse.setWarehouse(warehouseCRUDRepository.getOne(productWarehouseDTO.getWarehouseId()));
          productWarehouse.setUserEntity(userCRUDRepository.getOne(productWarehouseDTO.getProductId()));
          productWarehouse.setStockAmount(productWarehouseDTO.getStockAmount());
          productWarehouse.setTransactionDate(productWarehouseDTO.getTransactionDate());

          productWarehouseRepository.save(productWarehouse);
           return new WarehouseAPIResponseHolder<>(productWarehouseDTO, HttpStatus.OK);
        }
}
