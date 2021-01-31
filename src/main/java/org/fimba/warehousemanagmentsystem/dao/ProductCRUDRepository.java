package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductCRUDRepository extends JpaRepository<ProductEntity, Long> {
    @Query("SELECT w FROM ProductEntity w WHERE w.status ='ACTIVE' OR w.status ='PASSIVE' ")
    Collection<ProductEntity> findAllActiveAndPassive();
}
