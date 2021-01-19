package com.fimba.WarehouseManagmentSystem.model.Entities;

import com.fimba.WarehouseManagmentSystem.model.StatusEnums.ProductStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Setter
@Getter
@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity{

    @Column(name = "VAT_RATE",nullable = false,precision = 3,scale = 2)
    private BigDecimal vatRate = BigDecimal.valueOf(00.00);

    @Column(name = "VAT_AMOUNT",nullable = false,precision = 19,scale = 2)
    private BigDecimal vatAmount = BigDecimal.valueOf(00.00);

    @Column(name = "VAT_INCLUDED_PRICE",nullable = false,precision = 19,scale = 2)
    private BigDecimal vatIncludedPrice = BigDecimal.valueOf(00.00);


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false,length = 7)
    private ProductStatusEnum status;



}
