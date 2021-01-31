package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.UserStatus;
import org.fimba.warehousemanagmentsystem.model.enums.WarehouseStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@Entity
public class UserEntity extends BaseEntity{



    @Column(name = "EMAİL")
    private String email;


    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "STATUS",length = 7)
    @Enumerated(value=EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;
}
