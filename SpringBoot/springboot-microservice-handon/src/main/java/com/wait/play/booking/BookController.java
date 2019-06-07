package com.wait.play.booking;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wait.play.model.TravelViewObject;

import reactor.core.publisher.Mono;

@RestController
public class BookController {

  @Autowired
  private ReactiveTravelRepository travelRepository;


  @RequestMapping(value = "/travels", method = RequestMethod.GET)
  public Mono<List<TravelViewObject>> getAllTravel(@RequestParam String userId) {
    return travelRepository.getTravels(userId);
  }

  @RequestMapping("/greeting")
  @HystrixCommand(fallbackMethod = "reliable")
  public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    int i = new Random().nextInt(10);
    if (i / 3 == 0) {
      throw new RuntimeException();
    }
    return "Hello!";
  }

  public String reliable(String name) {
    return "reliable";
  }

  @RequestMapping("/secret")
  public String secret(@RequestParam(value = "name", defaultValue = "World") String name) {
    return "Secret!";
  }

}
