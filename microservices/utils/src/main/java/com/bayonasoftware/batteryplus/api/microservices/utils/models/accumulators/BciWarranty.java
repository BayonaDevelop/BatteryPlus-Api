package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

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
@Table(schema = "public", name = "bci_warranty", uniqueConstraints = @UniqueConstraint(columnNames = { "bci_base_id", "line_id", "brand_id", "sub_brand_id", "amperage" }))
public class BciWarranty implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_base_id")
  private BciBase base;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "line_id")
  private Line line;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "brand_id")
  private Brand brand;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sub_brand_id")
  private SubBrand subBrand;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "amperage", nullable = false)
  private String amperage;

  @Column(name = "active")
  private boolean active;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "warranty")
  private Set<Accumulator> accumulators;
}
