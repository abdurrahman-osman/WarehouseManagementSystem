package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.ProductStatus;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends BaseDTO{
    private BigDecimal vatRate;
    private BigDecimal vatAmount;
    private BigDecimal price;
    private BigDecimal vatIncludedPrice;
    private ProductStatus status;
}
