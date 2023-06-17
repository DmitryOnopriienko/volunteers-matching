package com.volunteers.matching.service;

import com.volunteers.matching.dto.VolunteerDataDto;

import java.util.List;

public interface VolunteerService {
  List<VolunteerDataDto> getAll();

  VolunteerDataDto getById(int id);
}
