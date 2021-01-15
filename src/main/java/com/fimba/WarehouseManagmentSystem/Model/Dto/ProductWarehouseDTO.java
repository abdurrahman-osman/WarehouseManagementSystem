package com.fimba.WarehouseManagmentSystem.Model.Dto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ProductWarehouseDTO {
    private ProductDTO product;
    private WarehouseDTO warehouse;
    private Long stockAmount;
    private Date transactionDate;
    private UserDTO user;
    private Long id;

}

