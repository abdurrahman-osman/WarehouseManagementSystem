package com.fimba.WarehouseManagmentSystem.Model.Entities;
import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductWarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    WarehouseEntity warehouseEntity;





}
