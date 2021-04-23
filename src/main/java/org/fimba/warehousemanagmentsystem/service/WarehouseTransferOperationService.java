package org.fimba.warehousemanagmentsystem.service;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseTransferDTO;

public interface WarehouseTransferOperationService {
    WarehouseAPIResponseHolder<?> transfer(WarehouseTransferDTO dto);
}
