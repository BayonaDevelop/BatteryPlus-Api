package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

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
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "bci_used", uniqueConstraints = @UniqueConstraint(columnNames = { "bci_base_id", "amperage" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class BciUsed implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_base_id")
  private BciBase base;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "amperage", nullable = false)
  private String amperage;

  @Column(name = "active")
  private boolean active;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "used")
  private Set<Accumulator> accumulators;
}
