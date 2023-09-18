package icu.jerryc05.confdemo.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
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

import icu.jerryc05.confdemo.models.Session;
import icu.jerryc05.confdemo.repositories.SessionRepository;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
  @Autowired
  private SessionRepository sessionRepository;

  @GetMapping
  @QueryMapping
  public List<Session> list() {
    return sessionRepository.findAll();
  }

  @GetMapping("{id}")
  @QueryMapping
  public Session get(@PathVariable Long id) {
    return sessionRepository.getReferenceById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @MutationMapping
  public Session create(@RequestBody final Session session) {
    return sessionRepository.saveAndFlush(session);
  }

  @DeleteMapping("{id}")
  @MutationMapping
  public void delete(@PathVariable Long id) {
    sessionRepository.deleteById(id);
  }

  @PutMapping("{id}")
  @MutationMapping
  public Session update(@PathVariable Long id, @RequestBody Session session) {
    // todo: return 400 if not all attributes are passed in
    Session existingSession = sessionRepository.getReferenceById(id);
    BeanUtils.copyProperties(session, existingSession, "session_id");
    return sessionRepository.saveAndFlush(existingSession);
  }
}
