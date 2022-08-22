package com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Client;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.CommercialBranch;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.math.BigInteger;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "address")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Address implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id")
  private Street street;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id_a")
  private Street streetA;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "street_id_b")
  private Street streetB;

  @Id
  @Column(name = "id", nullable = false)
  private BigInteger id;

  @Column(name = "Internal_Number", length = 60)
  private String internalNumber;

  @Column(name = "External_Number", length = 60)
  private String externalNumber;

  @Column(name = "Reference")
  private String reference;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  private Set<Client> clients;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  private Set<Person> people;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  private Set<CommercialBranch> commercialBranches;

}
