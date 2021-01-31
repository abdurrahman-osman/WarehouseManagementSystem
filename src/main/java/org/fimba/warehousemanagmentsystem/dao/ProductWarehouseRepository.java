package org.fimba.warehousemanagmentsystem.dao;

import org.fimba.warehousemanagmentsystem.model.entities.ProductWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ProductWarehouseRepository extends JpaRepository<ProductWarehouse,Long> {


    @Query(value = "insert into product_warehouse values (product_id,warehouse_id,transction_date,user_id,stock_amount)",nativeQuery = true)
    void add(Long productId, Long warehouseId, Date transactionDate, Long userId, Long stockAmount);
}
