package org.fimba.warehousemanagmentsystem.dao.WarehouseRepository;

import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WarehouseCRUDRepository extends JpaRepository<WarehouseEntity,Long> {
    @Query(value ="SELECT w FROM WarehouseEntity w WHERE w.warehouseStatus='ACTIVE' OR w.warehouseStatus='PASSIVE' ",nativeQuery = true)
    Collection<WarehouseEntity> findAllActiveAndPassive();


}
