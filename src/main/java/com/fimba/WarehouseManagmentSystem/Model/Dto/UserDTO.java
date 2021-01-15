package com.fimba.WarehouseManagmentSystem.Model.Dto;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.UserStatusEnum;

public class UserDTO extends BaseDTO{
    private String email;
    private String password;
    private UserStatusEnum status;
}
