package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.model.enums.ProductStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class ProductEntity extends BaseEntity{




    @Column(name = "VAT_RATE", precision = 4, scale = 2)
    private BigDecimal vatRate = BigDecimal.valueOf(00.00);


    @Column(name = "VAT_AMOUNT", precision = 19, scale = 2)
    private BigDecimal vatAmount = BigDecimal.valueOf(00.00);


    @Column(name = "PRICE", precision = 19, scale = 2, nullable = false)
    private BigDecimal price = BigDecimal.valueOf(00.00);


    @Column(name = "VAT_INCLUDED_PRICE", precision = 19, scale = 2, nullable = false)
    private BigDecimal vatIncludedPrice = BigDecimal.valueOf(00.00);

    @Enumerated(value = EnumType.STRING)
    @Column(name = "STATUS", length = 7, nullable = false)
    private ProductStatus status = ProductStatus.ACTIVE;



    @JsonIgnore
    @OneToMany(mappedBy = "productEntity")
    Set<ProductWarehouseEntity> warehouseEntities;
}
