package com.fimba.WarehouseManagmentSystem.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseError {
    String code;
    String message;
}
