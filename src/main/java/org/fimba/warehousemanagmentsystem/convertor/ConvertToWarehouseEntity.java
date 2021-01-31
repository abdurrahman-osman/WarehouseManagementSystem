package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class ConvertToWarehouseEntity implements WarehouseAPIBaseConvetor<WarehouseDTO, WarehouseEntity> {

    @Override
    public WarehouseEntity convertor(WarehouseDTO convert) {
        WarehouseEntity warehouseEntity = new WarehouseEntity();
        warehouseEntity.setId(convert.getId());
        warehouseEntity.setName(convert.getName());
        warehouseEntity.setCode(convert.getCode());
        warehouseEntity.setCreatedDate(Objects.isNull(convert.getCreatedDate()) ? new Date() : convert.getCreatedDate());
        warehouseEntity.setUpdatedDate(convert.getUpdatedDate());
        warehouseEntity.setStatus(convert.getStatus());
        return warehouseEntity;
    }


}
