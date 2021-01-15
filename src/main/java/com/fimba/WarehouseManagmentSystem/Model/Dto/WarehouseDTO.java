package com.fimba.WarehouseManagmentSystem.Model.Dto;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.WarehouseStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WarehouseDTO extends BaseDTO{
    private WarehouseStatusEnum status;
}
