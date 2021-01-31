package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDTO implements Serializable {
    private Long id;


    @NotEmpty(message = "Name is not empty")
    private String name;

    @NotEmpty(message = "Name is not empty")
    private String code;
    private Date createdDate;
    private Date updatedDate;
}
