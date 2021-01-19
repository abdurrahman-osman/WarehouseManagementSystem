package com.fimba.WarehouseManagmentSystem.model.dto;

import com.fimba.WarehouseManagmentSystem.model.StatusEnums.ProductStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends BaseDTO{
    private BigDecimal vatRate;
    private BigDecimal vatAmount;
    private BigDecimal price;
    private BigDecimal vatIncludedPrice;
    private ProductStatusEnum status;
}
