package com.wait.play.booking;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "travel-config")
public class BookingServiceSetting {

  private List<String> supportedDesitions;

  public List<String> getSupportedDesitions() {
    return supportedDesitions;
  }

  public void setSupportedDesitions(List<String> supportedDesitions) {
    this.supportedDesitions = supportedDesitions;
  }
}
