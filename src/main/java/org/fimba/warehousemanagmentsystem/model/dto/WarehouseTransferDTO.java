package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class WarehouseTransferDTO {
    private Long fromWarehouseId;
    private Long toWarehouseId;
}
