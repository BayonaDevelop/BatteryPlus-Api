package com.bayonasoftware.batteryplus.api.microservices.utils.models.movements;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators.Accumulator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "movement_detail", uniqueConstraints = @UniqueConstraint(columnNames = { "movement_id", "accumulator_id" }))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class MovementDetail implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "movement_id")
  private Movement movement;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "accumulator_id")
  private Accumulator accumulator;

  @Id
  @Column(name = "id", nullable = false)
  private BigInteger id;


}
