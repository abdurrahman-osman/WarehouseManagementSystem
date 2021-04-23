package org.fimba.warehousemanagmentsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class BaseDTO implements Serializable  {
    private Long id;


    @NotEmpty(message = "Name is not empty")
    private String name;

    @NotEmpty(message = "Code is not empty")
    private String code;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;
}
