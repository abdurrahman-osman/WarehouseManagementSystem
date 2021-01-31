package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertTOProductEntity implements WarehouseAPIBaseConvetor<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity convertor(ProductDTO convert) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(convert.getId());
        productEntity.setName(convert.getName());
        productEntity.setCode(convert.getCode());
        productEntity.setVatAmount(convert.getVatAmount());
        productEntity.setVatRate(convert.getVatRate());
        productEntity.setPrice(convert.getPrice());
        productEntity.setVatIncludedPrice(convert.getVatIncludedPrice());
        productEntity.setCreatedDate(convert.getCreatedDate());
        productEntity.setUpdatedDate(convert.getUpdatedDate());
        productEntity.setStatus(convert.getStatus());
        return productEntity;
    }
}
