package com.fimba.WarehouseManagmentSystem.converter.WarehouseConverterImpl;

import com.fimba.WarehouseManagmentSystem.converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.model.Entities.WarehouseEntity;
import com.fimba.WarehouseManagmentSystem.model.dto.WarehouseDTO;

public class DTOToWarehouseConverter implements BaseConverter<WarehouseEntity, WarehouseDTO> {

    @Override
    public WarehouseEntity convert(WarehouseDTO entity) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setCode(entity.getCode());
        warehouseEntity.setName(entity.getName());
        warehouseEntity.setStatus(entity.getStatus());
        warehouseEntity.setId(entity.getId());
        warehouseEntity.setCreatedAt(entity.getCreatedAt());
        warehouseEntity.setUpdatedAt(entity.getUpdatedAt());
        return warehouseEntity;
    }
}
