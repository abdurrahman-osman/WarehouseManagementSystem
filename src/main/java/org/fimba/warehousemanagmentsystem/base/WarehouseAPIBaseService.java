package org.fimba.warehousemanagmentsystem.base;

import org.fimba.warehousemanagmentsystem.model.dto.BaseDTO;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface WarehouseAPIBaseService<T extends BaseDTO> {
    WarehouseAPIResponseHolder<Collection<T>> list();

    WarehouseAPIResponseHolder<T> create(T dto);

    WarehouseAPIResponseHolder<T> update(T dto);

    WarehouseAPIResponseHolder<?> delete(T id);
}
