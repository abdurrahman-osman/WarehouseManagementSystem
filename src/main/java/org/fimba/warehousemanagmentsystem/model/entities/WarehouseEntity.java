package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class WarehouseEntity extends BaseEntity{




    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 7,nullable = false)
    private WarehouseStatus status = WarehouseStatus.ACTIVE;



    @JsonIgnore
    @OneToMany(mappedBy = "warehouseEntity")
    Set<ProductWarehouseEntity> warehouseEntities;

}
