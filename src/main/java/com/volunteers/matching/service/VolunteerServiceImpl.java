package com.volunteers.matching.service;

import com.volunteers.matching.dto.VolunteerDataDto;
import com.volunteers.matching.entity.Volunteer;
import com.volunteers.matching.exception.NotFoundException;
import com.volunteers.matching.repository.VolunteerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VolunteerServiceImpl implements VolunteerService {

  private final VolunteerRepository volunteerRepository;

  private final ModelMapper modelMapper;

  @Autowired
  public VolunteerServiceImpl(VolunteerRepository volunteerRepository, ModelMapper modelMapper) {
    this.volunteerRepository = volunteerRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<VolunteerDataDto> getAll() {
    List<Volunteer> volunteers = volunteerRepository.findAll();
    return volunteers.stream()
            .map(entity -> modelMapper.map(entity, VolunteerDataDto.class))
            .collect(Collectors.toList());
  }

  @Override
  public VolunteerDataDto getById(int id) {
    Volunteer volunteer = volunteerRepository.findById(id).orElseThrow(() ->
            new NotFoundException("Volunteer with id %d not found".formatted(id)));
    return modelMapper.map(volunteer, VolunteerDataDto.class);
  }
}
