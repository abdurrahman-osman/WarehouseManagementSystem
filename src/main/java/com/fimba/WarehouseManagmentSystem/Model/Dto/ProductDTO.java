package com.fimba.WarehouseManagmentSystem.Model.Dto;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.ProductStatusEnum;
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
