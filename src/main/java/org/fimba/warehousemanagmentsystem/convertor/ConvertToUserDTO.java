package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertToUserDTO implements WarehouseAPIBaseConvetor<UserEntity, UserDTO> {
    @Override
    public UserDTO convertor(UserEntity convert) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(convert.getId());
        userDTO.setName(convert.getName());
        userDTO.setEmail(convert.getEmail());
        userDTO.setPassword(convert.getPassword());
        userDTO.setCode(convert.getCode());
        userDTO.setCreatedDate(convert.getCreatedDate());
        userDTO.setUpdatedDate(convert.getUpdatedDate());
        userDTO.setStatus(convert.getStatus());
        return userDTO;
    }
}
