package com.fimba.WarehouseManagmentSystem.Dao;

import com.fimba.WarehouseManagmentSystem.Model.Entities.BaseEntity;

import java.util.Collection;

public interface WarehouseAPICRUDRepository<T extends BaseEntity,ID extends Long> {

        Collection<T> list();

        T create(T entity);

        T update(T entity);

        void delete(ID id);

}
