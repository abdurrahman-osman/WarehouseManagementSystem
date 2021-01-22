package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class UserEntity extends BaseEntity{

    @Column(name = "EMAİL",unique = true,length = 20,nullable = false)
    private String email;

    @Column(name = "PASSWORD",nullable = false)
    private String password;

    @Column(name = "STATUS",length = 7,nullable = false)
    @Enumerated(value=EnumType.STRING)
    private WarehouseStatus warehouseStatus = WarehouseStatus.ACTIVE;
}
