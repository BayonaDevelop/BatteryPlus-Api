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
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "client")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Client implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "Code", length = 10)
  private String code;

  @Column(name = "legal_name", nullable = false)
  private String legalName;

  @Column(name = "commercial_name", nullable = false)
  private String commercialName;

  @Column(name = "rfc")
  private String rfc;

  @Column(name = "uso_cfdi")
  private String usoCFDI;

  @Column(name = "email")
  private String email;

  @Column(name = "classification")
  private String classification;

  @Column(name = "seller")
  private String seller;

  @Column(name = "has_vehicle_fleet")
  private String vehicleFleet;

  @Column(name = "active", nullable = false)
  private boolean active;
}
