package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOperationRepository extends JpaRepository<WarehouseEntity,Long> {
    @Query("select w from  WarehouseEntity w where w.code=?1")
    WarehouseEntity findWarehouseEntityByCode(String code);
}
