package com.volunteers.matching.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "organization")
public class Organization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private String description;

  private String email;

  private String phone;

  @OneToMany(mappedBy = "organization")
  @JsonManagedReference
  private List<Initiative> initiatives;

  @OneToMany(mappedBy = "organization")
  @JsonManagedReference
  private List<InitiativeProposal> proposals;

  public List<InitiativeProposal> getProposals() {
    return proposals;
  }

  public void setProposals(List<InitiativeProposal> proposals) {
    this.proposals = proposals;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<Initiative> getInitiatives() {
    return initiatives;
  }

  public void setInitiatives(List<Initiative> initiatives) {
    this.initiatives = initiatives;
  }
}
