package com.fimba.WarehouseManagmentSystem.model.dto;

import com.fimba.WarehouseManagmentSystem.model.StatusEnums.UserStatusEnum;

public class UserDTO extends BaseDTO{
    private String email;
    private String password;
    private UserStatusEnum status;
}
