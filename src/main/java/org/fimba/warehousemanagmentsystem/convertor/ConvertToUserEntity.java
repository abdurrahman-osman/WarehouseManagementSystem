package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;

import org.springframework.stereotype.Component;

@Component
public class ConvertToUserEntity implements WarehouseAPIBaseConvetor<UserDTO, UserEntity> {
    @Override
    public UserEntity convertor(UserDTO convert) {
       UserEntity userEntity = new UserEntity();
        userEntity.setId(convert.getId());
        userEntity.setName(convert.getName());
        userEntity.setEmail(convert.getEmail());
        userEntity.setPassword(convert.getPassword());
        userEntity.setCode(convert.getCode());
        userEntity.setCreatedDate(convert.getCreatedDate());
        userEntity.setUpdatedDate(convert.getUpdatedDate());
        userEntity.setStatus(convert.getStatus());
        return userEntity;
    }
}
