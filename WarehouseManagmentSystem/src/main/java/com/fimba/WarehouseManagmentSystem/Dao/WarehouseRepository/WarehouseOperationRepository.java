package com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository;

public interface WarehouseOperationRepository {
    boolean hasExistSameWarehouseCode(String warehouseCode);
}
