package com.bayonasoftware.batteryplus.api.microservices.utils.models.movements;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Client;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Person;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.WarehouseSection;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.oauth.User;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "movement")
@JsonIgnoreProperties("hibernateLazyInitializer")
public class Movement implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_section_origin_id", nullable = false)
  private WarehouseSection origin;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "warehouse_section_destination_id")
  private WarehouseSection destination;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_public_attention_id")
  private User userPublicAttention;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id")
  private Person person;

  @Id
  @Column(name = "id", nullable = false)
  private BigInteger id;

  @Column(name = "type", nullable = false)
  private short type;

  @Column(name = "status", nullable = false)
  private short status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "reception_date", length = 23, nullable = false)
  private Date receptionDate;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "movement")
  private Set<MovementDetail> details;

}
