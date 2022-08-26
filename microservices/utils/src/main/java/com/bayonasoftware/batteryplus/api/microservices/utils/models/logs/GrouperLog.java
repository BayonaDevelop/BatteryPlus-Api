package com.bayonasoftware.batteryplus.api.microservices.utils.models.logs;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.accumulators.Grouper;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.oauth.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "grouper_log")
public class GrouperLog implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "entity_id", nullable = false)
  private Grouper grouper;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Id
  @Column(name = "id", nullable = false)
  private BigInteger id;

  @Column(name = "status", nullable = false)
  private short status;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "event_date", length = 23, nullable = false)
  private Date eventDate;
}
