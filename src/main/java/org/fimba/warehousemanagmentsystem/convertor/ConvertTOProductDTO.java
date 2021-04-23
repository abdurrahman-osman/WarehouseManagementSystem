package org.fimba.warehousemanagmentsystem.convertor;

import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.entities.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ConvertTOProductDTO implements WarehouseAPIBaseConvetor<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity convert) {
        ProductDTO productDTO  = new ProductDTO();
        productDTO.setId(convert.getId());
        productDTO.setName(convert.getName());
        productDTO.setCode(convert.getCode());
        productDTO.setVatAmount(convert.getVatAmount());
        productDTO.setVatRate(convert.getVatRate());
        productDTO.setPrice(convert.getPrice());
        productDTO.setVatIncludedPrice(convert.getVatIncludedPrice());
        productDTO.setCreatedDate(convert.getCreatedDate());
        productDTO.setUpdatedDate(convert.getUpdatedDate());
        productDTO.setStatus(convert.getStatus());
        return productDTO;
    }
}
