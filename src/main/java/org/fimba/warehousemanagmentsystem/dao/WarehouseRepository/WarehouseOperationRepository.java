package org.fimba.warehousemanagmentsystem.dao.WarehouseRepository;

import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehouseOperationRepository extends JpaRepository<WarehouseEntity,Long> {
   boolean existsWarehouseEntityByCode(String code);
}
