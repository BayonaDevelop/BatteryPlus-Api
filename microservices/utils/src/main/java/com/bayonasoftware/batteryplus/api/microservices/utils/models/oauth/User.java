package com.bayonasoftware.batteryplus.api.microservices.utils.models.oauth;

import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.CommercialBranch;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.catalogs.Person;
import com.bayonasoftware.batteryplus.api.microservices.utils.models.movements.Movement;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(schema = "public", name = "app_user", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
@JsonIgnoreProperties("hibernateLazyInitializer")
public class User implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "commercial_branch_id", nullable = false)
  private CommercialBranch commercialBranch;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "username", nullable = false)
  private String username;

  @Column(name = "name", nullable = false)
  private String password;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "app_users_roles", schema = "public", joinColumns = {
      @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = {
      @JoinColumn(name = "role_id", nullable = false, updatable = false) })
  private Set<Role> roles;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private Set<Movement> movements;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "userPublicAttention")
  private Set<Movement> movementsAttended;

}
