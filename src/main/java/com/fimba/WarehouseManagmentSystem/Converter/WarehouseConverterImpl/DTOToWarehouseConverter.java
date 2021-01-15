package com.fimba.WarehouseManagmentSystem.Converter.WarehouseConverterImpl;

import com.fimba.WarehouseManagmentSystem.Converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;
import com.fimba.WarehouseManagmentSystem.Model.Dto.WarehouseDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DTOToWarehouseConverter implements BaseConverter<WarehouseEntity, WarehouseDTO> {

    @Override
    public WarehouseEntity convert(WarehouseDTO DTO) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setCode(DTO.getCode());
        warehouseEntity.setName(DTO.getName());
        warehouseEntity.setStatus(DTO.getStatus());
        warehouseEntity.setId(DTO.getId());
        warehouseEntity.setCreatedAt(DTO.getCreatedAt());
        warehouseEntity.setUpdatedAt(new Date());
        return warehouseEntity;
    }
}
