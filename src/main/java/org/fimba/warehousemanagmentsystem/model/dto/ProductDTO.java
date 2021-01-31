package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.ProductStatus;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends BaseDTO{

    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatRate;


    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatAmount;

    @PositiveOrZero(message = "You do not negative")
    private BigDecimal price;


    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatIncludedPrice;

    private ProductStatus status = ProductStatus.ACTIVE;
}
