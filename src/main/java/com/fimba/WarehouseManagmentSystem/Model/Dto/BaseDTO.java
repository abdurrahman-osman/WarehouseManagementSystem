package com.fimba.WarehouseManagmentSystem.Model.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter

public class BaseDTO implements Serializable {

    private Long id;
    @Email
    private String name;
    @Email
    private String code;
    private Date createdAt;
    private Date updatedAt;

}
