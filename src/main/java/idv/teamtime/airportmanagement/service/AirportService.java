package idv.teamtime.airportmanagement.service;

import com.mongodb.client.result.DeleteResult;
import idv.teamtime.airportmanagement.domain.Airport;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

  private final MongoTemplate mongoTemplate;

  public AirportService(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public Airport findById(String id) {
    return mongoTemplate.findById(id, Airport.class);
  }

  public Airport createAirport(Airport airport) {
    return mongoTemplate.insert(airport);
  }

  public Airport updateAirport(String id, Airport airport) {
    Airport original = findById(id);
    if (null == original) {
      return mongoTemplate.insert(airport);
    }
    original.setName(airport.getName());
    original.setFlightsPerDay(airport.getFlightsPerDay());
    original.setClosed(airport.getClosed());
    original.setLocation(airport.getLocation());
    return mongoTemplate.save(original);
  }

  public Long deleteAirport(String id) {
    Airport original = findById(id);
    if ((null == original)) {
      return -1L;
    }
    DeleteResult result = mongoTemplate.remove(original);
    return result.getDeletedCount();
  }

  public Integer deleteAll() {
    List<Airport> result = mongoTemplate.findAllAndRemove(new Query(), Airport.class);
    return result.size();
  }

}
