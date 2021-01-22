package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    private String email;
    private String password;
    private WarehouseStatus warehouseStatus;
}
