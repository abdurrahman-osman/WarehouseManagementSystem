package org.fimba.warehousemanagmentsystem.Controller;

import lombok.RequiredArgsConstructor;
import org.fimba.warehousemanagmentsystem.Service.Impl.WarehouseCRUDServiceImpl;
import org.fimba.warehousemanagmentsystem.Service.WarehouseCRUDService;
import org.fimba.warehousemanagmentsystem.model.dto.WarehouseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouses")
public class WarehouseController {
    private final WarehouseCRUDService warehouseCRUDService;

    @GetMapping
    public ResponseEntity<Collection<WarehouseDTO>> list(){
        return warehouseCRUDService.list();
    }
    @PostMapping
    public ResponseEntity<WarehouseDTO> create(@RequestBody @Valid WarehouseDTO warehouseDTO){
        return warehouseCRUDService.create(warehouseDTO);
    }
    @PutMapping
    public  ResponseEntity<WarehouseDTO> update(@RequestBody @Valid WarehouseDTO warehouseDTO){
        return warehouseCRUDService.update(warehouseDTO);
    }
    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid WarehouseDTO warehouseDTO){
        return warehouseCRUDService.delete(warehouseDTO);
    }



}
