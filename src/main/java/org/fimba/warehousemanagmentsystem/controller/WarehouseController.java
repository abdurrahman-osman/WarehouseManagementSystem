package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.service.WarehouseCRUDService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouseapi/warehouses")
public class WarehouseController {

    private final WarehouseCRUDService warehouseCRUDService;

    @GetMapping()
    public WarehouseAPIResponseHolder<Collection<WarehouseDTO>> list() {
        return warehouseCRUDService.list();
    }

    @GetMapping("{id}")
    public WarehouseAPIResponseHolder<WarehouseDTO> getById(@PathVariable Long id) {
        return warehouseCRUDService.getById(id);
    }
    

    @PostMapping
    public WarehouseAPIResponseHolder<WarehouseDTO> create(@Valid @RequestBody  WarehouseDTO dto) {

        return warehouseCRUDService.create(dto);
    }

    @PutMapping("/{id}")
    public WarehouseAPIResponseHolder<WarehouseDTO> update(@RequestBody WarehouseDTO dto, @PathVariable Long id) {
        return warehouseCRUDService.update(dto,id);
    }

    @DeleteMapping("{id}")
    public WarehouseAPIResponseHolder<?> delete(@PathVariable Long id) {
        return warehouseCRUDService.delete(id);
    }
}
