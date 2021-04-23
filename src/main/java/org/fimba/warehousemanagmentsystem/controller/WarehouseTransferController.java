package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseTransferDTO;
import org.fimba.warehousemanagmentsystem.service.WarehouseTransferOperationService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouseapi/warehouses/transfer")

public class WarehouseTransferController {
    private final WarehouseTransferOperationService transferOperationService;

    @PostMapping
    public WarehouseAPIResponseHolder<?> transfer(@RequestBody WarehouseTransferDTO dto){
        return transferOperationService.transfer(dto);
    }

}
