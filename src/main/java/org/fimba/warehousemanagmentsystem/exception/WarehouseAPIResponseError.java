package org.fimba.warehousemanagmentsystem.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WarehouseAPIResponseError {
    private String code;
    private String message;
}
