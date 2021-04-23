package org.fimba.warehousemanagmentsystem.service;

public interface TransferOperationService {
    boolean isExist(Long productId, Long toWarehouseId);
}
