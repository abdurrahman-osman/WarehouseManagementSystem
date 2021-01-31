package org.fimba.warehousemanagmentsystem.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.fimba.warehousemanagmentsystem.base.WarehouseAPIBaseConvetor;
import org.fimba.warehousemanagmentsystem.model.entities.UserEntity;
import org.fimba.warehousemanagmentsystem.model.entities.WarehouseEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class ProductWarehouseDTO  {

  @NotNull
  private Long productId;
  @NotNull
  private Long warehouseId;
  @NotNull
  private Long userId;
  @NotNull
  private Long stockAmount;
  @NotNull
  private Date transactionDate;
}
