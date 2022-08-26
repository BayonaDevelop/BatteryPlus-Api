package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "sub_brand", uniqueConstraints = @UniqueConstraint(columnNames = { "brand_id", "name" }))
public class SubBrand implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "initials", nullable = false)
  private String initials;

  @Column(name = "suffix", nullable = false)
  private String suffix;

  @Column(name = "active")
  private boolean active;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subBrand")
  private Set<BciWarranty> bciWarranties;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "subbrand")
  private Set<CoverageSubBrand> coverages;

}
