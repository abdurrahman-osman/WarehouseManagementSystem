package org.fimba.warehousemanagmentsystem.dao;


import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;

@Repository
public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouseEntity,Long> {


    @Query("select w.warehouseEntity.name,w.productEntity.name,w.productEntity.price,w.productEntity.vatAmount," +
            "w.productEntity.vatIncludedPrice from  ProductWarehouseEntity w")
    Collection<?>  findAllByProductWarehouse();

    @Transactional
    @Modifying
    @Query("update ProductWarehouseEntity  set warehouseEntity.id = :toWarehouseId where warehouseEntity.id = :fromWarehouseId " +
            "and productEntity.id = :productId")
    void transfer(@Param("toWarehouseId") Long toWarehouseId, @Param("fromWarehouseId") Long fromWarehouseId, @Param("productId") Long productId);

    @Transactional
    @Query("select p from ProductWarehouseEntity p where p.warehouseEntity.id= :warehouseId " +
            "and p.productEntity.id= :productId")
    ProductWarehouseEntity update(@Param("warehouseId") Long warehouseId, @Param("productId") Long productId);

}
