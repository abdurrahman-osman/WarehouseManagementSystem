package org.fimba.warehousemanagmentsystem.Converter.WarehouseConverter;

import org.fimba.warehousemanagmentsystem.Converter.BaseConverter;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.stereotype.Component;

@Component
public class ConverterToWarehouseDTO implements BaseConverter<WarehouseEntity,WarehouseDTO> {
    @Override
    public WarehouseDTO convert(WarehouseEntity warehouseEntity) {

        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setCode(warehouseEntity.getCode());
        warehouseDTO.setName(warehouseEntity.getName());
        warehouseDTO.setStatus(warehouseEntity.getStatus());
        warehouseDTO.setId(warehouseEntity.getId());
        warehouseDTO.setUpdatedDate(warehouseEntity.getUpdatedDate());
        warehouseDTO.setCreatedDate(warehouseEntity.getCreatedDate());


        return warehouseDTO;
    }
}
