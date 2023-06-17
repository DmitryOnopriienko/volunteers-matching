package com.volunteers.matching.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VolunteerSaveDto {

  private Integer id;

  @NotBlank(message = "Name is mandatory")
  private String name;

  @NotBlank(message = "Surname is mandatory")
  private String surname;

  @NotBlank(message = "Email is mandatory")
  private String email;

  @NotBlank(message = "Phone is mandatory")
  private String phone;

  @NotNull(message = "City is mandatory")
  @Min(value = 1, message = "City is mandatory")
  private Integer cityId;

  public VolunteerSaveDto() {
  }

  public VolunteerSaveDto(Integer id, String name, String surname, String email, String phone, Integer cityId) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
    this.cityId = cityId;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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

  public int getCityId() {
    return cityId;
  }

  public void setCityId(int cityId) {
    this.cityId = cityId;
  }
}
