package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.convertor.ConvertTOProductDTO;
import org.fimba.warehousemanagmentsystem.convertor.ConvertTOProductEntity;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.DuplicateException;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.enums.ProductStatus;
import org.fimba.warehousemanagmentsystem.service.ProductCRUDService;
import org.fimba.warehousemanagmentsystem.service.ProductOperationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductCRUDServiceImpl implements ProductCRUDService {

    private final ProductCRUDRepository productCRUDRepository;
    private final ConvertTOProductDTO convertTOProductDTO;
    private final ConvertTOProductEntity convertTOProductEntity;
    private final ProductOperationService productOperationService;


    @Override
    public WarehouseAPIResponseHolder<Collection<ProductDTO>> list() {

        Collection<ProductEntity> productEntities = productCRUDRepository.findAllActive();

        //checking if there is not products
        if (productEntities.isEmpty()) {
            throw new ResourceNotFoundException(("PRODUCT LIST NOT FOUND"));
        }
        List<ProductDTO> productDTOList = productEntities
                .stream()
                .map(convertTOProductDTO::convert)
                .collect(Collectors.toList());

        return new WarehouseAPIResponseHolder<>(productDTOList, HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<ProductDTO> getById(Long id) {
        ProductEntity productEntity = productCRUDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PRODUCT NOT FOUND"));
        ProductDTO productDTO = convertTOProductDTO.convert(productEntity);

        return new WarehouseAPIResponseHolder<>(productDTO, HttpStatus.OK);
    }


    @Override
    public WarehouseAPIResponseHolder<ProductDTO> create(ProductDTO dto) {

        //checking if new entity's code exist or not
        if (productOperationService.isExist(dto.getCode())) {
            throw new DuplicateException("Duplicate Code");
        }

        // convert to entity from dto
        ProductEntity productEntity = convertTOProductEntity.convert(dto);
        productEntity.setCreatedDate(new Date());
        ProductEntity savedEntity = productCRUDRepository.save(productEntity);
        ProductDTO productDTO = convertTOProductDTO.convert(savedEntity);

        return new WarehouseAPIResponseHolder<>(productDTO, HttpStatus.OK);
    }


    @Override
    public WarehouseAPIResponseHolder<ProductDTO> update(ProductDTO dto, Long id) {

        //checking if the entity which will be update exist in db or not
        if (productOperationService.isExist(dto.getCode())) {
            throw new DuplicateException("Duplicate Code");
        }
        //Get the entity which will be update
        ProductEntity updateEntity = productCRUDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PRODUCT NOT FOUND"));

        Date date = updateEntity.getCreatedDate();
        dto.setId(id);
        updateEntity = convertTOProductEntity.convert(dto);
        updateEntity.setCreatedDate(date);
        updateEntity.setUpdatedDate(new Date());

        productCRUDRepository.save(updateEntity);
        ProductDTO productDTO = convertTOProductDTO.convert(updateEntity);
        return new WarehouseAPIResponseHolder<>(productDTO, HttpStatus.OK);

    }

    @Override
    public WarehouseAPIResponseHolder<?> delete(Long id) {
        //Get the entity which will be delete
        ProductEntity productEntity = productCRUDRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PRODUCT NOT FOUND"));
        productEntity.setStatus(ProductStatus.PASSIVE);
        productCRUDRepository.save(productEntity);

        return new WarehouseAPIResponseHolder<>(HttpStatus.OK);

    }
}
