package com.volunteers.matching.controller;

import com.volunteers.matching.dto.VolunteerDataDto;
import com.volunteers.matching.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {

  private final VolunteerService volunteerService;

  @Autowired
  public VolunteerController(VolunteerService volunteerService) {
    this.volunteerService = volunteerService;
  }

  @GetMapping("/")
  public List<VolunteerDataDto> getAll() {
    return volunteerService.getAll();
  }

  @GetMapping("/{id}")
  public VolunteerDataDto getById(@PathVariable int id) {
    return volunteerService.getById(id);
  }
}
