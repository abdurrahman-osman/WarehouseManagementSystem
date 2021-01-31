package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToUserDTO;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToUserEntity;
import org.fimba.warehousemanagmentsystem.dao.UserCRUDRepository;
import org.fimba.warehousemanagmentsystem.model.dto.UserDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.service.UserCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class UserCRUDServiceImpl implements UserCRUDService {
    private final UserCRUDRepository userCRUDRepository;
    private final ConvertToUserDTO convertToUserDTO;
    private final ConvertToUserEntity convertToUserEntity;

    @Override
    public WarehouseAPIResponseHolder<Collection<UserDTO>> list() {
        Collection<UserEntity> userEntities = userCRUDRepository.findAllActiveAndPassive();
        List<UserDTO> userDTOS = userEntities
                .stream()
                .map(convertToUserDTO::convertor)
                .collect(Collectors.toList());
        return new WarehouseAPIResponseHolder<>(userDTOS, HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<UserDTO> create(UserDTO dto) {
        UserEntity userEntity = convertToUserEntity.convertor(dto);
        userEntity.setCreatedDate(new Date());
        UserEntity savedEntity = userCRUDRepository.save(userEntity);
        UserDTO userDTO = convertToUserDTO.convertor(savedEntity);
        return new WarehouseAPIResponseHolder<>(userDTO,HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<UserDTO> update(UserDTO dto) {
        return null;
    }

    @Override
    public WarehouseAPIResponseHolder<?> delete(UserDTO id) {
        return null;
    }
}
