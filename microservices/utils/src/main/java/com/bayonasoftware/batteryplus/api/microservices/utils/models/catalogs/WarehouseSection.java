package com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "warehouse_section", uniqueConstraints = @UniqueConstraint(columnNames = { "warehouse_id", "name" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class WarehouseSection implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_id", nullable = false)
  private Warehouse warehouse;

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;
}
