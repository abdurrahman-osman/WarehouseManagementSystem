package com.fimba.WarehouseManagmentSystem.Service;

import com.fimba.WarehouseManagmentSystem.Model.Dto.BaseDTO;
import com.fimba.WarehouseManagmentSystem.Response.ResponseHolder;

import java.util.Collection;

public interface WarehouseAPIBaseService<T extends BaseDTO> {

        ResponseHolder<Collection<T>> list();

        ResponseHolder<T> create(T entity);

        ResponseHolder<T> update(T entity);

        ResponseHolder<?> delete(T idEntity);
}
