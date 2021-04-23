package org.fimba.warehousemanagmentsystem.base;

import org.fimba.warehousemanagmentsystem.model.dto.BaseDTO;


import java.util.Collection;

public interface WarehouseAPIBaseService<T extends BaseDTO> {
    WarehouseAPIResponseHolder<Collection<T>> list();

    WarehouseAPIResponseHolder<T> create(T dto);

    WarehouseAPIResponseHolder<T> getById(Long id);

    WarehouseAPIResponseHolder<T> update(T dto,Long id);

    WarehouseAPIResponseHolder<?> delete(Long id);
}
