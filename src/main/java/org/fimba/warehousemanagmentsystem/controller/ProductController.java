package org.fimba.warehousemanagmentsystem.controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIResponseHolder;
import org.fimba.warehousemanagmentsystem.model.dto.ProductDTO;
import org.fimba.warehousemanagmentsystem.service.ProductCRUDService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collection;

@RequiredArgsConstructor
@RestController
@RequestMapping("/warehouseapi/products")
public class ProductController {
    private final ProductCRUDService productCRUDService;

    @GetMapping
    public WarehouseAPIResponseHolder<Collection<ProductDTO>> list() {
        return productCRUDService.list();
    }

    @GetMapping("/{id}")
    public WarehouseAPIResponseHolder<ProductDTO> getById(@PathVariable Long id) {
        return productCRUDService.getById(id);
    }

    @PostMapping
    public WarehouseAPIResponseHolder<ProductDTO> create(@Valid @RequestBody ProductDTO dto) {

        return productCRUDService.create(dto);
    }

    @PutMapping("/{id}")
    public WarehouseAPIResponseHolder<ProductDTO> update(@Valid @RequestBody ProductDTO dto, @PathVariable Long id)  {
        return productCRUDService.update(dto,id);
    }

    @DeleteMapping("/{id}")
    public WarehouseAPIResponseHolder<?> delete(@PathVariable Long id) {
        return productCRUDService.delete(id);
    }
}
