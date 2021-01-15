package com.fimba.WarehouseManagmentSystem.Model.Entities;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.WarehouseStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "WAREHOUSE")
public class WarehouseEntity extends BaseEntity{


    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS",length = 7, nullable = false)
    private WarehouseStatusEnum status = WarehouseStatusEnum.ACTIVE;
}
