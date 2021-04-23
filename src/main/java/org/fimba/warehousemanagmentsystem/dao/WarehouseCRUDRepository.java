package org.fimba.warehousemanagmentsystem.dao;


import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;



@Repository
public interface WarehouseCRUDRepository extends JpaRepository<WarehouseEntity, Long> {
   @Query("SELECT w FROM WarehouseEntity w WHERE w.status ='ACTIVE' or w.status = 'PASSIVE' ")
   Collection<WarehouseEntity> findAllActive();
}
