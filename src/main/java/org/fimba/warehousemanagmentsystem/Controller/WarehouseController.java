package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.service.WarehouseCRUDService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseCRUDService warehouseCRUDService;

    @GetMapping
    public WarehouseAPIResponseHolder<Collection<WarehouseDTO>> list() {
        return warehouseCRUDService.list();
    }

    @PostMapping
    public WarehouseAPIResponseHolder<WarehouseDTO> create(@Valid @RequestBody  WarehouseDTO dto) {

        return warehouseCRUDService.create(dto);
    }

    @PutMapping
    public WarehouseAPIResponseHolder<WarehouseDTO> update(@Valid @RequestBody WarehouseDTO dto) {
        return warehouseCRUDService.update(dto);
    }

    @DeleteMapping
    public WarehouseAPIResponseHolder<?> delete(@RequestBody WarehouseDTO id) {
        return warehouseCRUDService.delete(id);
    }
}
