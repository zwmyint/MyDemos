package com.wait.play.booking;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.wait.play.App;
import com.wait.play.model.Travel;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@ActiveProfiles("local")
public class TravelRepositionTest {

  @Autowired
  public TravelRepository travelRepository;

  @Test
  public void saveTravel() {
    String userId = "tom";
    Travel travel = new Travel(userId, "LONDON", "CRETE");
    travelRepository.save(travel);
    List<Travel> travels = travelRepository.findByUserId(userId);
    Assert.assertTrue(travels.get(0).getSource().equals("LONDON"));
    Assert.assertTrue(travels.get(0).getDestination().equals("CRETE"));
  }

  @Test
  public void findByDestination() {
    List<Travel> travels = Arrays
        .asList(new Travel(UUID.randomUUID().toString(), "SWISSRE", "CRETE"), new Travel(
                UUID.randomUUID().toString(), "LONDON", "LONDON"),
            new Travel(UUID.randomUUID().toString(), "SWISSRE", "CRETE"));
    travelRepository.saveAll(travels);
    List<Travel> founds = travelRepository.findByDestination("CRETE");
    Assert.assertTrue(founds.size() == 2);
  }

}
