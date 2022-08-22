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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "person")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Person implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "second_last_name")
  private String secondLastName;

  @Column(name = "ine")
  private String ine;

  @Column(name = "driver_license")
  private String driverLicense;

  @Column(name = "rfc")
  private String rfc;

  @Column(name = "uso_cfdi")
  private String usoCFDI;

  @Column(name = "email")
  private String email;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
  private Set<Telephone> telephones;
}
