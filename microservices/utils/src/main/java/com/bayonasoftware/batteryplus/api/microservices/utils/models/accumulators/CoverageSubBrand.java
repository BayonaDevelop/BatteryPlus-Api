package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

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
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "coverage_sub_brand", uniqueConstraints = @UniqueConstraint(columnNames = { "coverage_type_id", "sub_brand_id", "months_start", "months_end", "percentage" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class CoverageSubBrand implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "coverage_type_id")
  private CoverageType type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_brand_id")
  private SubBrand subbrand;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "months_start", nullable = false)
  private short monthsStart;

  @Column(name = "months_end", nullable = false)
  private short monthsEnd;

  @Column(name = "percentage", nullable = false)
  private float percentage;

}
