package com.fimba.WarehouseManagmentSystem.Converter.WarehouseConverterImpl;

import com.fimba.WarehouseManagmentSystem.Converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;
import com.fimba.WarehouseManagmentSystem.Model.Dto.WarehouseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class WarehouseToDTOConverter implements BaseConverter<WarehouseDTO, WarehouseEntity> {
    @Override
    public WarehouseDTO convert(WarehouseEntity entity) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setCode(entity.getCode());
        warehouseDTO.setName(entity.getName());
        warehouseDTO.setStatus(entity.getStatus());
        warehouseDTO.setId(entity.getId());
        warehouseDTO.setUpdatedAt(entity.getUpdatedAt());
        warehouseDTO.setCreatedAt(entity.getCreatedAt());
        return warehouseDTO;
    }
}
