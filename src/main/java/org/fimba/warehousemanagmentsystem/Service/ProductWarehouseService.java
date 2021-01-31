package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseService;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductWarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;

public interface ProductWarehouseService{
    WarehouseAPIResponseHolder<ProductWarehouseDTO> add(ProductWarehouseDTO productWarehouseDTO);

}
