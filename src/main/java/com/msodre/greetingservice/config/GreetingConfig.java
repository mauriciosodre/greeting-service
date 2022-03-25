package com.msodre.greetingservice.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Data
@Component
@RefreshScope
@ConfigurationProperties("greeting-service")
public class GreetingConfig {

  private String greeting;
  private String defaultValue;
}
