package org.fimba.warehousemanagmentsystem.Converter;

public interface BaseConverter<T,R> {
    R convert(T entity);
}
