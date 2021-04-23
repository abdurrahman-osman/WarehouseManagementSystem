package org.fimba.warehousemanagmentsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.dao.TransferOperationRepository;
import org.fimba.warehousemanagmentsystem.service.TransferOperationService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TransferOperationServiceImpl implements TransferOperationService {

    private final TransferOperationRepository transferOperationRepository;

    @Override
    public boolean isExist(Long productId, Long toWarehouseId) {
        if(transferOperationRepository.isExist(productId,toWarehouseId)==null){
            return false;
        }

        return true;
    }
}
