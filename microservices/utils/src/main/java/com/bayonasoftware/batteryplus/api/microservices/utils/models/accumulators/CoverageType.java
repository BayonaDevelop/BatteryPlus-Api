package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

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
@Table(schema = "public", name = "coverage_type", uniqueConstraints = @UniqueConstraint(columnNames = { "name" }))
public class CoverageType implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  private Set<CoverageBciBase> coveragesBase;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  private Set<CoverageBrand> coveragesBrand;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "type")
  private Set<CoverageSubBrand> coveragesSubBrand;

}
