package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
public class WarehouseEntity extends BaseEntity{



    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL)
    private Set<ProductWarehouse> productWarehouses;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 7,nullable = false)
    private WarehouseStatus status = WarehouseStatus.ACTIVE;

}
