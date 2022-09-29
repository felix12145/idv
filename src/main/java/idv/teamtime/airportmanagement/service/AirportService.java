package idv.teamtime.airportmanagement.service;

import idv.teamtime.airportmanagement.domain.Airport;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

  private final MongoTemplate mongoTemplate;

  public AirportService(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  // 1)
  public Airport findById(String id) {
    // Implementation here
    return new Airport();
  }

  // 2)
  // U can use src/main/resources/create_airport.json to insert the airport via Postman
  public Airport createAirport(Airport airport) {
    // Implementation here
    return new Airport();
  }

  // 3)
  // U can modify and use src/main/resources/create_airport.json to update the created Airport via Postman
  public Airport updateAirport(String id, Airport airport) {
    // Implementation here
    return new Airport();
  }

  // 4)
  // returns the amount of deleted Airports
  public Long deleteAirport(String id) {
    // Implementation here
    return -1L;
  }

  // 5)
  // returns the amount of deleted Airports
  public Integer deleteAll() {
    // Implementation here
    return -1;
  }
}
