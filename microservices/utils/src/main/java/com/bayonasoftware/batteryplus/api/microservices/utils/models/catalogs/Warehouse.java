package com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses.Address;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.logs.WarehouseLog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "warehouse", uniqueConstraints = @UniqueConstraint(columnNames = { "commercial_branch_id", "name" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Warehouse implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commercial_branch_id", nullable = false)
  private CommercialBranch commercialBranch;

  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "active", nullable = false)
  private boolean active;


  @Column(name = "Latitude", precision = 16, scale = 10)
  private BigDecimal latitude;

  @Column(name = "Longitude", precision = 16, scale = 10)
  private BigDecimal longitude;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
  private Set<WarehouseSection> sections;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warehouse")
  private Set<WarehouseLog> logs;

}
