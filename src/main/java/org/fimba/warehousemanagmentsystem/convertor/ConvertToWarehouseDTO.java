package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertToWarehouseDTO implements WarehouseAPIBaseConvetor<WarehouseEntity, WarehouseDTO> {
    @Override
    public WarehouseDTO convert(WarehouseEntity convert) {
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setId(convert.getId());
        warehouseDTO.setName(convert.getName());
        warehouseDTO.setCode(convert.getCode());
        warehouseDTO.setCreatedDate(convert.getCreatedDate());
        warehouseDTO.setUpdatedDate(convert.getUpdatedDate());
        warehouseDTO.setStatus(convert.getStatus());
        return warehouseDTO;
    }
}
