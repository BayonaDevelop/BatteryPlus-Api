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
@Table(schema = "public", name = "bci_base", uniqueConstraints = @UniqueConstraint(columnNames = { "group_id", "name" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class BciBase implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "group_id")
  private Grouper grouper;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "active")
  private boolean active;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  private Set<BciUsed> used;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  private Set<BciWarranty> warranties;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "base")
  private Set<CoverageBciBase> coverages;
}
