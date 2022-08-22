package com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "commercial_branch")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class CommercialBranch implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "matrix_id", nullable = false)
  private CommercialBranch matrix;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "legal_name", nullable = false)
  private String legalName;

  @Column(name = "commercial_name", nullable = false)
  private String commercialName;

  @Column(name = "active")
  private boolean active;

  @Column(name = "main")
  private boolean main;

  @Column(name = "Latitude", precision = 16, scale = 10)
  private BigDecimal latitude;

  @Column(name = "Longitude", precision = 16, scale = 10)
  private BigDecimal longitude;
}
