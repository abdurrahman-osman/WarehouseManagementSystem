package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ProductWarehouseId implements Serializable {

    @Column(name = "products")
    private Long productId ;

    @Column(name = "warehouses")
    private Long warehouseId ;

    @Column(name = "users")
    private Long userId ;

}
