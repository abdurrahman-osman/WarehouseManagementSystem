package com.fimba.WarehouseManagmentSystem.model.dto;

import com.fimba.WarehouseManagmentSystem.model.StatusEnums.WarehouseStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDTO extends BaseDTO{
    private WarehouseStatusEnum status;
}
