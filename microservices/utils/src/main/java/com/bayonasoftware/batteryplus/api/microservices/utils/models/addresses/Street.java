package com.bayonasoftware.batteryplus.api.microservices.utils.models.addresses;

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
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "street")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Street implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "colony_id")
  private Colony colony;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "street")
  private Set<Address> addresses;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "streetA")
  private Set<Address> addressesA;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "streetB")
  private Set<Address> addressesB;
}
