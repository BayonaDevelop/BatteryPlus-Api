package com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.movements.MovementDetail;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "accumulator")
public class Accumulator implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_used_id")
  private BciUsed used;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bci_warranty_id")
  private BciWarranty warranty;

  @Id
  @Column(name = "id", nullable = false)
  private BigInteger id;

  @Column(name = "previous_status")
  private short previousStatus;

  @Column(name = "status", nullable = false)
  private short status;

  @Column(name = "policy")
  private String policy;

  @Column(name = "bill")
  private String bill;

  @Column(name = "purchase_note")
  private String purchaseNote;

  @Column(name = "voltage", precision = 16, nullable = false)
  private BigDecimal voltage;

  @Column(name = "price", precision = 16, nullable = false)
  private BigDecimal price;

  @Column(name = "taxi_driver", nullable = false)
  private boolean taxiDriver;

  @Column(name = "pressable", nullable = false)
  private boolean pressable;

  @Column(name = "borrowed", nullable = false)
  private boolean borrowed;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "admission_date", length = 23, nullable = false)
  private Date admissionDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "policy_date", length = 23)
  private Date policyDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "sale_date", length = 23)
  private Date saleDate;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "accumulator")
  private Set<MovementDetail> details;

}
