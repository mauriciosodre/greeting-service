package com.msodre.greetingservice.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.msodre.greetingservice.config.GreetingConfig;
import com.msodre.greetingservice.model.Greeting;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetingController {

  private static final String TEMPLATE = "%s, %s!";
  private final AtomicLong counter = new AtomicLong();

  private GreetingConfig config;

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    if(name.isEmpty()) name = config.getDefaultValue();
    return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, config.getGreeting(), name));
  }
}
