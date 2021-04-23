package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.dao.WarehouseOperationRepository;
import org.fimba.warehousemanagmentsystem.service.WarehouseOperationService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WarehouseOperationServiceImpl implements WarehouseOperationService {
    private final WarehouseOperationRepository warehouseOperationRepository;
    @Override
    public boolean isExist(String code) {
        if(warehouseOperationRepository.findWarehouseEntityByCode(code)==null){
            return false;
        }
        return true;
    }
}
