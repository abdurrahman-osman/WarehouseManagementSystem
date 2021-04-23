package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.ProductStatus;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO extends BaseDTO{
    @NotNull(message = "Vat Rate Price is not null")
    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatRate;

    @NotNull(message = "Vat Amount Price is not null")
    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatAmount;

    @PositiveOrZero(message = "You do not negative")
    @NotNull(message = "Vat Price is not null")
    private BigDecimal price;

    @NotNull(message = "Vat Included Price is not null")
    @PositiveOrZero(message = "You do not negative")
    private BigDecimal vatIncludedPrice;

    private ProductStatus status = ProductStatus.ACTIVE;
}
