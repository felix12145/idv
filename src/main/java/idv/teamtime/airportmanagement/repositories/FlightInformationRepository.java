package idv.teamtime.airportmanagement.repositories;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

  @Query()
  List<FlightInformation> findInternationalFlightsByDeparture(String departure);
  @Query()
  List<FlightInformation> findByDuration(int minDuration, int maxDuration);
  @Query()
  List<FlightInformation> findRelatedToCityAndNotDelayed(String city);
}
