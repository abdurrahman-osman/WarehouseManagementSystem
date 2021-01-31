package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.fimba.warehousemanagmentsystem.service.ProductCRUDService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductCRUDService productCRUDService;

    @GetMapping
    public WarehouseAPIResponseHolder<Collection<ProductDTO>> list() {
        return productCRUDService.list();
    }

    @PostMapping
    public WarehouseAPIResponseHolder<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {

        return productCRUDService.create(dto);
    }

    @PutMapping
    public WarehouseAPIResponseHolder<ProductDTO> update(@Valid @RequestBody ProductDTO dto) {
        return productCRUDService.update(dto);
    }

    @DeleteMapping
    public WarehouseAPIResponseHolder<?> delete(@RequestBody ProductDTO id) {
        return productCRUDService.delete(id);
    }
}
