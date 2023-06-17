package com.volunteers.matching.dto;

import com.volunteers.matching.entity.City;
import com.volunteers.matching.entity.Skill;

import java.util.List;

public class VolunteerDataDto {

  private int id;

  private String name;

  private String surname;

  private String email;

  private String phone;

  private City city;

  private List<Skill> skills;

  public VolunteerDataDto() {
  }

  public VolunteerDataDto(int id, String name, String surname, String email, String phone, City city, List<Skill> skills) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
    this.city = city;
    this.skills = skills;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
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

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public List<Skill> getSkills() {
    return skills;
  }

  public void setSkills(List<Skill> skills) {
    this.skills = skills;
  }
}
