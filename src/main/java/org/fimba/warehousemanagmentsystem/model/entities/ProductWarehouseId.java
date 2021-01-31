package org.fimba.warehousemanagmentsystem.model.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@Embeddable
public class ProductWarehouseId implements Serializable {

     private Long warehouseId;
     private Long productId;
     private Long userId;

}
