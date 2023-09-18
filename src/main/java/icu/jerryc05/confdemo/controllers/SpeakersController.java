package icu.jerryc05.confdemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import icu.jerryc05.confdemo.models.Speaker;
import icu.jerryc05.confdemo.repositories.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
  @Autowired
  private SpeakerRepository speakerRepository;

  @GetMapping
  public List<Speaker> list() {
    return speakerRepository.findAll();
  }

  @GetMapping("{id}")
  public Speaker get(@PathVariable Long id) {
    return speakerRepository.getReferenceById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Speaker create(@RequestBody final Speaker speaker) {
    return speakerRepository.saveAndFlush(speaker);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable Long id) {
    speakerRepository.deleteById(id);
  }

  @PutMapping("{id}")
  public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
    // todo: return 400 if not all attributes are passed in
    Speaker existingSpeaker = speakerRepository.getReferenceById(id);
    BeanUtils.copyProperties(speaker, existingSpeaker, "session_id");
    return speakerRepository.saveAndFlush(existingSpeaker);
  }
}
