package com.fimba.WarehouseManagmentSystem.Model.Entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODE" ,nullable = false,unique = true,length = 50)
    private String code;

    @Column(name = "NAME" ,nullable = false,length = 50)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE" ,nullable = false,updatable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_DATE")
    private Date updatedAt;
}
