package com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(schema = "addresses", name = "country")
public class Country implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "code", length = 10)
  private String code;

  @Column(name = "code_iso2", length = 10)
  private String codeISO2;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "postal_code_regex")
  private String postalCodeRegex;

  @Column(name = "sat_registry_regex")
  private String satRegistryRegex;

  @Column(name = "region", length = 60)
  private String region;

  @Column(name = "coat_of_arms")
  private String coatOfArms;

  @Column(name = "flag")
  private String flag;

}
