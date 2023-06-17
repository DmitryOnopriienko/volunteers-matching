package com.volunteers.matching.service;

import com.volunteers.matching.dto.VolunteerDataDto;
import com.volunteers.matching.dto.VolunteerSaveDto;

import java.util.List;

public interface VolunteerService {
  List<VolunteerDataDto> getAll();

  VolunteerDataDto getById(int id);

  int createVolunteer(VolunteerSaveDto volunteerSaveDto);

  void updateVolunteer(VolunteerSaveDto volunteerSaveDto, int id);
}
