package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

@Getter
@Setter
public class WarehouseDTO extends BaseDTO {

    private WarehouseStatus status = WarehouseStatus.ACTIVE;
}
