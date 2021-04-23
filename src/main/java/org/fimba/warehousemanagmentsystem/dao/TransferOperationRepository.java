package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferOperationRepository extends JpaRepository<ProductWarehouseEntity,Long> {

    @Query("select pw from ProductWarehouseEntity pw where pw.productEntity.id = :productId and pw.warehouseEntity.id = :toWarehouseId")
    ProductWarehouseEntity isExist(@Param("productId") Long productId, @Param("toWarehouseId") Long toWarehouseId);
}
