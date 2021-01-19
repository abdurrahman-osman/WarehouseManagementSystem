package com.fimba.WarehouseManagmentSystem.converter;

public interface BaseConverter<T,R>{

    T convert(R entity);
}
