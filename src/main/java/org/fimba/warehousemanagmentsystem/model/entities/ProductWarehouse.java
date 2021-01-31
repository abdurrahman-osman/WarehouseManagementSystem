package org.fimba.warehousemanagmentsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class ProductWarehouse {
    @EmbeddedId
    ProductWarehouseId productWarehouseId;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    ProductEntity product ;

    @ManyToOne
    @MapsId("warehouseId")
    @JoinColumn(name = "warehouse_id")
    WarehouseEntity warehouse ;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    UserEntity userEntity;

    @Column(name = "stockAmount")
    private Long stockAmount;

    @Column(name = "transctionDate")
    private Date transactionDate;


}
