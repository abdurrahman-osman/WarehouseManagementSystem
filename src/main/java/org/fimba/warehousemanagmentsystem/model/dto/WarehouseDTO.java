package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseId;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import java.util.Set;

@Getter
@Setter
public class WarehouseDTO extends BaseDTO {

    private ProductWarehouseId productWarehouseId;
    private WarehouseStatus status = WarehouseStatus.ACTIVE;
}
