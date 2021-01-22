package org.fimba.warehousemanagmentsystem.Service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fimba.warehousemanagmentsystem.Converter.WarehouseConverter.ConverterToWarehouseDTO;
import org.fimba.warehousemanagmentsystem.Converter.WarehouseConverter.ConverterToWarehouseEntity;
import org.fimba.warehousemanagmentsystem.Service.WarehouseCRUDService;
import org.fimba.warehousemanagmentsystem.dao.WarehouseRepository.WarehouseCRUDRepository;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Service
@RequiredArgsConstructor
@Slf4j
public class WarehouseCRUDServiceImpl implements WarehouseCRUDService {
    private final WarehouseCRUDRepository warehouseCRUDRepository;
    private final ConverterToWarehouseDTO converterToWarehouseDTO;
    private final ConverterToWarehouseEntity converterToWarehouseEntity;

    @Override
    public ResponseEntity<Collection<WarehouseDTO>> list() {
        Collection<WarehouseEntity> warehouseEntities = warehouseCRUDRepository.findAllActiveAndPassive();
        Collection<WarehouseDTO> warehouseDTOS = new ArrayList<>();
        for (WarehouseEntity warehouseEntity : warehouseEntities) {
            warehouseDTOS.add(converterToWarehouseDTO.convert(warehouseEntity));
        }
        return new ResponseEntity<>(warehouseDTOS,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WarehouseDTO> create(WarehouseDTO dto) {
        WarehouseEntity warehouseEntity = converterToWarehouseEntity.convert(dto);
        warehouseEntity.setCreatedDate(new Date());

        warehouseEntity = warehouseCRUDRepository.save(warehouseEntity);
        dto = converterToWarehouseDTO.convert(warehouseEntity);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WarehouseDTO> update(WarehouseDTO dto) {
        WarehouseEntity warehouseEntity = converterToWarehouseEntity.convert(dto);
        warehouseEntity.setUpdatedDate(new Date());
        warehouseCRUDRepository.save(warehouseEntity);
        dto.setCreatedDate(warehouseCRUDRepository.getOne(dto.getId()).getCreatedDate());
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<WarehouseDTO> delete(WarehouseDTO idDto) {
        WarehouseEntity warehouseEntity = warehouseCRUDRepository.getOne(idDto.getId());
        warehouseEntity.setStatus(WarehouseStatus.DELETED);
        warehouseCRUDRepository.save(warehouseEntity);
        idDto = converterToWarehouseDTO.convert(warehouseEntity);
        return ResponseEntity.ok(idDto);
    }
}
