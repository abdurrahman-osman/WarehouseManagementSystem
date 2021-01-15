package com.fimba.WarehouseManagmentSystem.Converter.ProductConverterImpl;

import com.fimba.WarehouseManagmentSystem.Converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.Model.Entities.ProductEntity;
import com.fimba.WarehouseManagmentSystem.Model.Dto.ProductDTO;

import java.util.Date;
import java.util.Objects;

public class DTOToProductConverter implements BaseConverter<ProductEntity, ProductDTO> {

    @Override
    public ProductEntity convert(ProductDTO entity) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setStatus(entity.getStatus());
        productEntity.setCode(entity.getCode());
        productEntity.setId(entity.getId());
        productEntity.setName(entity.getName());
        productEntity.setVatAmount(entity.getVatAmount());
        productEntity.setVatRate(entity.getVatRate());
        productEntity.setVatIncludedPrice(entity.getVatIncludedPrice());
        productEntity.setUpdatedAt(entity.getUpdatedAt());
        if (Objects.isNull(entity.getCreatedAt())) productEntity.setCreatedAt(new Date());
        else productEntity.setCreatedAt(entity.getCreatedAt());
        return productEntity;
    }
}
