package com.fimba.WarehouseManagmentSystem.model.Entities;

import com.fimba.WarehouseManagmentSystem.model.StatusEnums.UserStatusEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Entity
@Table(name = "TABLE")
public class UserEntity extends BaseEntity{

    @Email
    @NotEmpty(message = "Please Enter your Email")
    @Column(name = "EMAİL")
    private String email;


    @NotEmpty(message = "Please enter your password")
    @Column(name = "PASSWORD")
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",length = 7)
    private UserStatusEnum status;

}
