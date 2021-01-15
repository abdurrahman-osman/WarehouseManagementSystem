package com.fimba.WarehouseManagmentSystem.Model.Entities;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.UserStatusEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
@Getter
@Setter
@Entity
@Table(name = "USER")
public class UserEntity extends BaseEntity{


    @NotEmpty(message = "Please Enter your Email")
    @Column(name = "EMAIL")
    private String email;


    @NotEmpty(message = "Please enter your password")
    @Column(name = "PASSWORD",nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 7)
    private UserStatusEnum status = UserStatusEnum.ACTIVE;

}
