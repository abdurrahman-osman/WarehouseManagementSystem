package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.dto.WarehouseTransferDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface WarehouseTransferOperationRepository extends JpaRepository<ProductWarehouseEntity,Long> {

    @Query("select p from ProductWarehouseEntity p where p.warehouseEntity.id= :fromWarehouseId")
    Collection<ProductWarehouseEntity> getProductsByFromWarehouseId(@Param("fromWarehouseId") Long fromWarehouseId);

    @Query("select p from ProductWarehouseEntity p where p.warehouseEntity.id= :toWarehouseId")
    Collection<ProductWarehouseEntity> getProductsByToWarehouseId(@Param("toWarehouseId") Long toWarehouseId);
}
