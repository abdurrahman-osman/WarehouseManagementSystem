package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.convertor.ConvertTOProductDTO;
import org.fimba.warehousemanagmentsystem.dao.ProductCRUDRepository;
import org.fimba.warehousemanagmentsystem.exception.ResourceNotFoundException;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.service.ProductOperationService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@RequiredArgsConstructor
@Service
public class ProductOperationServiceImpl implements ProductOperationService {

    private final ProductCRUDRepository productCRUDRepository;
    private final ConvertTOProductDTO convertTOProductDTO;

    public ProductDTO findProductDTOById(Long productID){
            ProductEntity productEntity = productCRUDRepository.findById(productID)
                    .orElseThrow(()-> new ResourceNotFoundException("Not null"));
             ProductDTO productDTO = convertTOProductDTO.convertor(productEntity);
        return  productDTO;

    }
}
