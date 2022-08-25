package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Telephone;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "grouper", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Grouper implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "letter", nullable = false)
  private String letter;

  @Column(name = "color", nullable = false)
  private String color;

  @Column(name = "active")
  private boolean active;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "grouper")
  private Set<BciBase>  bciBases;

}
