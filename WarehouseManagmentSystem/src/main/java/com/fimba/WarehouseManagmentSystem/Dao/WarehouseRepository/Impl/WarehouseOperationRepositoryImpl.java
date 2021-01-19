package com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.Impl;

import com.fimba.WarehouseManagmentSystem.Dao.AbstractWarehouseAPICRUDRepository;
import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseOperationRepository;
import com.fimba.WarehouseManagmentSystem.Model.Entities.WarehouseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WarehouseOperationRepositoryImpl extends AbstractWarehouseAPICRUDRepository<WarehouseEntity,Long>implements WarehouseOperationRepository {

    @Override
    public boolean hasExistSameWarehouseCode(String warehouseCode) {
        Long result = getSession()
                .createQuery("select count (*) from WarehouseEntity w where w.code =: givenCode",Long.class)
                .setParameter("givenCode",warehouseCode)
                .uniqueResult();
        return result > 0;
    }
}
