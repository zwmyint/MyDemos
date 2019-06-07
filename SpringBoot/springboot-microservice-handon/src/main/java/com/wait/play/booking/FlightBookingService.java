package com.wait.play.booking;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wait.play.model.Travel;

@Component
public class FlightBookingService implements BookingService {

  @Autowired
  public BookingServiceSetting bookingServiceSetting;

  @Autowired
  public TravelRepository travelRepository;

  @Override
  public boolean book(Travel travel) {
    if (bookingServiceSetting.getSupportedDesitions().contains(travel.getDestination())) {
      travelRepository.save(travel);
      return true;
    }
    return false;
  }

  @PostConstruct
  public void init() {
    System.out.println(">>>>In init method.<<<<");
  }

  @PreDestroy
  public void cleanup() {
    System.out.println(">>>>In cleanup method.<<<<");
  }
}
