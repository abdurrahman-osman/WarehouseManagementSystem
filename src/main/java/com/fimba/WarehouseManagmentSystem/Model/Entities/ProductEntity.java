package com.fimba.WarehouseManagmentSystem.Model.Entities;

import com.fimba.WarehouseManagmentSystem.Model.StatusEnums.ProductStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;


@Setter
@Getter
@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity{

    @Column(name = "VAT_RATE",nullable = false,precision = 3,scale = 2)
    @Positive
    private BigDecimal vatRate = BigDecimal.valueOf(00.00);

    @Column(name = "VAT_AMOUNT",nullable = false,precision = 19,scale = 2)
    @Positive
    private BigDecimal vatAmount = BigDecimal.valueOf(00.00);

    @Column(name = "VAT_INCLUDED_PRICE",nullable = false,precision = 19,scale = 2)
    @Positive(message = "Pozitif bir değer giriniz.")
    private BigDecimal vatIncludedPrice = BigDecimal.valueOf(00.00);


    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS",nullable = false,length = 7)
    private ProductStatusEnum status = ProductStatusEnum.ACTIVE;



}
