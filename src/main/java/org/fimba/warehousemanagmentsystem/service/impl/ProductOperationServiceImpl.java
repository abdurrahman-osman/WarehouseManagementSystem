package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;

import org.fimba.warehousemanagmentsystem.dao.ProductOperationRepository;
import org.fimba.warehousemanagmentsystem.service.ProductOperationService;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProductOperationServiceImpl implements ProductOperationService {
    private final ProductOperationRepository productOperationRepository;

    // checking if the given code is exist before or not
    @Override
    public boolean isExist(String code) {
        if(productOperationRepository.findProductEntityByCode(code)==null){
            return false;
        }
        return true;
    }
}

