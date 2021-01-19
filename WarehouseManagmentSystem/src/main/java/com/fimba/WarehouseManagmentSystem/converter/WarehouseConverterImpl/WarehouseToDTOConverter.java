package com.fimba.WarehouseManagmentSystem.converter.WarehouseConverterImpl;

import com.fimba.WarehouseManagmentSystem.converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.model.Entities.WarehouseEntity;
import com.fimba.WarehouseManagmentSystem.model.dto.WarehouseDTO;
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
        if (Objects.isNull(entity.getCreatedAt())) warehouseDTO.setCreatedAt(new Date());
        else warehouseDTO.setUpdatedAt(entity.getUpdatedAt());
        return warehouseDTO;
    }
}
