package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class WarehouseDTO extends BaseDTO {
    @NotEmpty
    private WarehouseStatus status;
}
