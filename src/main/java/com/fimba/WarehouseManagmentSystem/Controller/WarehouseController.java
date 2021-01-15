package com.fimba.WarehouseManagmentSystem.Controller;

import com.fimba.WarehouseManagmentSystem.Dao.WarehouseRepository.WarehouseCRUDRepository;
import com.fimba.WarehouseManagmentSystem.Model.Dto.WarehouseDTO;
import com.fimba.WarehouseManagmentSystem.Response.ResponseHolder;
import com.fimba.WarehouseManagmentSystem.Service.WarehouseService.WarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("warehouses")
@RequiredArgsConstructor
public class WarehouseController {
    private final WarehouseService warehouseService;

    @PostMapping
    public ResponseHolder<WarehouseDTO> create(@RequestBody @Valid WarehouseDTO warehouseDTO){

        return warehouseService.create(warehouseDTO);
    }
}
