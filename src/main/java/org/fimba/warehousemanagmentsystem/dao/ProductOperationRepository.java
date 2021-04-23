package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOperationRepository extends JpaRepository<ProductEntity,Long> {
    @Query("select w from  ProductEntity w where w.code=?1")
    ProductEntity findProductEntityByCode(String code);
}
