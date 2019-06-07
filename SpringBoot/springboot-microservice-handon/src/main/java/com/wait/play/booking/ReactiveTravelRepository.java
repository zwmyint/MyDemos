package com.wait.play.booking;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wait.play.model.Travel;
import com.wait.play.model.TravelViewObject;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Component
public class ReactiveTravelRepository {

  @Autowired
  private TravelRepository travelRepository;

  public Mono<List<TravelViewObject>> getTravels(String userId) {
    return Mono.defer(() -> Mono.just(travelRepository.findByUserId(userId))).subscribeOn(
        Schedulers.elastic()).map(
        p -> p.stream()
            .map(p1 -> new TravelViewObject(p1.getUserId(), p1.getSource(), p1.getDestination()))
            .collect(Collectors.toList()));
  }

  public Mono<TravelViewObject> saveTravel(TravelViewObject travelViewObject) {
    return Mono.just(travelViewObject).map(
        t -> new Travel(travelViewObject.getUserId(), travelViewObject.getSource(),
            travelViewObject.getDestination())).publishOn(Schedulers.parallel())
        .doOnNext(travelRepository::save)
        .map(t -> new TravelViewObject(t.getUserId(), t.getSource(), t.getDestination()));
  }
}
