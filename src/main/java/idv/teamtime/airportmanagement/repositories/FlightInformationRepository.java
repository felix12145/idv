package idv.teamtime.airportmanagement.repositories;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

  @Query(
      value = "{ $and : [{ 'departure.location.city' : ?0}, { type : 'International'}]}",
      fields = "{duration:1, isDelayed:1, 'departure.name':1, 'destination.name':1, type:1}")
  List<FlightInformation> findInternationalFlightsByDeparture(String departure);

  @Query(value = "{ 'durationMin' : { $gte : ?0, $lte : ?1}}", sort = "{'durationMin' : -1}")
  List<FlightInformation> findByDuration(int minDuration, int maxDuration);
}
