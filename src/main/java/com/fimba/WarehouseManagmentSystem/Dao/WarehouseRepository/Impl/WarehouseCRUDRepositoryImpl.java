package com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.Impl;

import com.fimba.WarehouseManagmentSystem.Dao.AbstractWarehouseAPICRUDRepository;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseCRUDRepository;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseCRUDRepositoryImpl extends AbstractWarehouseAPICRUDRepository<WarehouseEntity,Long> implements WarehouseCRUDRepository {
}
