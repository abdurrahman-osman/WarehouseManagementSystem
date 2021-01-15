package com.fimba.WarehouseManagmentSystem.Converter.ProductConverterImpl;

import com.fimba.WarehouseManagmentSystem.Converter.BaseConverter;
import com.fimba.WarehouseManagmentSystem.Model.Entities.ProductEntity;
import com.fimba.WarehouseManagmentSystem.Model.Dto.ProductDTO;

import java.util.Date;
import java.util.Objects;

public class ProductToDTOConverter implements BaseConverter<ProductDTO, ProductEntity> {
    @Override
    public ProductDTO convert(ProductEntity entity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setStatus(entity.getStatus());
        productDTO.setCode(entity.getCode());
        productDTO.setId(entity.getId());
        productDTO.setName(entity.getName());
        productDTO.setVatAmount(entity.getVatAmount());
        productDTO.setVatRate(entity.getVatRate());
        productDTO.setVatIncludedPrice(entity.getVatIncludedPrice());
        productDTO.setUpdatedAt(entity.getUpdatedAt());
        if (Objects.isNull(entity.getCreatedAt())) productDTO.setCreatedAt(new Date());
        else productDTO.setCreatedAt(entity.getCreatedAt());
        return productDTO;
    }
}
