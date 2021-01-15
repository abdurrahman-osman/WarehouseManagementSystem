package com.fimba.WarehouseManagmentSystem.Converter;

public interface BaseConverter<T,R>{

    T convert(R entity);
}
