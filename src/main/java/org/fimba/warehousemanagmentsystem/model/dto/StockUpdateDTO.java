package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockUpdateDTO {

    private Long productId;
    private Long warehouseId;
    private Long stock;

}
