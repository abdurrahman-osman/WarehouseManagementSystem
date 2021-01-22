package org.fimba.warehousemanagmentsystem.Converter.WarehouseConverter;

import org.fimba.warehousemanagmentsystem.Converter.BaseConverter;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConverterToWarehouseEntity implements BaseConverter<WarehouseDTO, WarehouseEntity> {
    @Override
    public WarehouseEntity convert(WarehouseDTO warehouseDTO) {

        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setCode(warehouseDTO.getCode());
        warehouseEntity.setName(warehouseDTO.getName());
        warehouseEntity.setStatus(warehouseDTO.getStatus());
        warehouseEntity.setId(warehouseDTO.getId());
        warehouseEntity.setCreatedDate(warehouseDTO.getCreatedDate());
        warehouseEntity.setUpdatedDate(new Date());

        return warehouseEntity;
    }
}
