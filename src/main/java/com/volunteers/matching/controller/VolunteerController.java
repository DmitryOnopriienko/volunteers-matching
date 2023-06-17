package com.volunteers.matching.controller;

import com.volunteers.matching.dto.RestResponse;
import com.volunteers.matching.dto.VolunteerDataDto;
import com.volunteers.matching.dto.VolunteerSaveDto;
import com.volunteers.matching.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

  @PostMapping("/create")
  @ResponseStatus(HttpStatus.CREATED)
  public RestResponse createVolunteer(@RequestBody @Valid VolunteerSaveDto volunteerSaveDto) {
    int id = volunteerService.createVolunteer(volunteerSaveDto);
    return new RestResponse(String.valueOf(id));
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateVolunteer(@RequestBody @Valid VolunteerSaveDto volunteerSaveDto,
                              @PathVariable int id) {
    volunteerService.updateVolunteer(volunteerSaveDto, id);
  }
}
