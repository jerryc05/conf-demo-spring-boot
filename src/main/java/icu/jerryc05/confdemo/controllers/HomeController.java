package icu.jerryc05.confdemo.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @Value("${app.version}")
  private String appVersion;

  @GetMapping("/")
  public Map<Object, Object> getStatus() {
    return Map.of("app-version", appVersion);
  }
}
