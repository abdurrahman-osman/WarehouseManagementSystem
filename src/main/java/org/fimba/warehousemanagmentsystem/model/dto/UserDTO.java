package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.UserStatus;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    @Email
    private String email;
    private String password;
    private UserStatus status = UserStatus.ACTIVE;
}
