package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToWarehouseDTO;
import org.fimba.warehousemanagmentsystem.convertor.ConvertToWarehouseEntity;
import org.fimba.warehousemanagmentsystem.dao.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.DuplicateException;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;
import org.fimba.warehousemanagmentsystem.service.WarehouseCRUDService;
import org.fimba.warehousemanagmentsystem.service.WarehouseOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WarehouseCRUDServiceImpl implements WarehouseCRUDService {

    private final ConvertToWarehouseDTO convertToWarehouseDTO;
    private final ConvertToWarehouseEntity convertToWarehouseEntity;
    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final WarehouseOperationService warehouseOperationService;

    @Override
    public WarehouseAPIResponseHolder<Collection<WarehouseDTO>> list() {
        Collection<WarehouseEntity> warehouseEntities = warehouseCRUDRepository.findAllActive();
             if(warehouseEntities.isEmpty()) {
                 throw new ResourceNotFoundException("WAREHOUSE LIST NOT FOUND");
             }
        List<WarehouseDTO> warehouseDTOList = warehouseEntities
                .stream()
                .map(convertToWarehouseDTO::convert)
                .collect(Collectors.toList());
        return new WarehouseAPIResponseHolder<>(warehouseDTOList);
    }

    @Override
    public WarehouseAPIResponseHolder<WarehouseDTO> getById(Long id) {
            WarehouseEntity warehouseEntity = warehouseCRUDRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("WAREHOUSE NOT FOUND"));
            WarehouseDTO warehouseDTO = convertToWarehouseDTO.convert(warehouseEntity);

         return new WarehouseAPIResponseHolder<>(warehouseDTO,HttpStatus.OK);

    }


    @Override
    public WarehouseAPIResponseHolder<WarehouseDTO> create(WarehouseDTO dto) {

        if(warehouseOperationService.isExist(dto.getCode())){
            throw new DuplicateException("Duplicate Code");
        }

        WarehouseEntity warehouseEntity = convertToWarehouseEntity.convert(dto);
        warehouseEntity.setCreatedDate(new Date());

        WarehouseEntity savedEntity = warehouseCRUDRepository.save(warehouseEntity);
        WarehouseDTO warehouseDTO = convertToWarehouseDTO.convert(savedEntity);
        return new WarehouseAPIResponseHolder<>(warehouseDTO,HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<WarehouseDTO> update(WarehouseDTO dto,Long id) {
        if(warehouseOperationService.isExist(dto.getCode())){
            throw new DuplicateException("Duplicate Code");
        }
       WarehouseEntity updateEntity = warehouseCRUDRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("WAREHOUSE NOT FOUND"));
        Date date = updateEntity.getCreatedDate();
        dto.setId(id);
        updateEntity = convertToWarehouseEntity.convert(dto);
        updateEntity.setCreatedDate(date);
        updateEntity.setUpdatedDate(new Date());
        warehouseCRUDRepository.save(updateEntity);
        WarehouseDTO warehouseDTO = convertToWarehouseDTO.convert(updateEntity);
        

        return new WarehouseAPIResponseHolder<>(warehouseDTO,HttpStatus.OK);

    }

    @Override
    public WarehouseAPIResponseHolder<?> delete(Long id) {
        WarehouseEntity warehouseEntity = warehouseCRUDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PRODUCT NOT FOUND"));
        warehouseEntity.setStatus(WarehouseStatus.PASSIVE);
        warehouseCRUDRepository.save(warehouseEntity);
        return new WarehouseAPIResponseHolder<>(HttpStatus.OK);

    }

}
