package com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository;

import com.fimba.WarehouseManagmentSystem.Dao.AbstractWarehouseAPICRUDRepository;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseAPICRUDRepository;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;

import java.util.Collection;

public interface WarehouseCRUDRepository {

    Collection<WarehouseEntity> list();

    WarehouseEntity create(WarehouseEntity entity);

    WarehouseEntity update(WarehouseEntity entity);

    void delete(Long id);


}
