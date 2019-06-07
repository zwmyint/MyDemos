package com.wait.play.booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wait.play.model.Travel;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {

  List<Travel> findAll();

  @Query("select t from Travel t where t.userId = :userId")
  List<Travel> findByUserId(@Param("userId") String userId);

  @Query("select t from Travel t where t.destination = :destination")
  List<Travel> findByDestination(@Param("destination") String destination);
}
