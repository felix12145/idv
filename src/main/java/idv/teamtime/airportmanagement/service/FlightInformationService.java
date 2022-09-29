package idv.teamtime.airportmanagement.service;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class FlightInformationService {

  private final MongoTemplate mongoTemplate;

  public FlightInformationService(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  // TODO: Implement the following queries

  //  1) Implement: Find all flights but return only the fields departure.name, destination.name, duration and isDelayed
  public List<FlightInformation> findAll() {
    Query query = new Query();

    return this.mongoTemplate.find(query, FlightInformation.class);
  }


  //  2) Implement: Find all international flights by departure city
  //  Question: How many international flights start from Rome? Whats the dastination airport?
  public List<FlightInformation> findInternationFlightsByDeparture(String departure) {
    Query departureQuery = new Query();

    return this.mongoTemplate.find(departureQuery, FlightInformation.class);
  }

  //  3) Implement: Find all flights by duration between min and max (inclusive min and max) sort by duration-min desc
  //  Question: Fetch the endpoint with minDuration = 50 and maxDuration = 150. How many flights do you count?
  public List<FlightInformation> findByDuration(int minDuration, int maxDuration) {
    Query byDurationBetween = new Query();

    return this.mongoTemplate.find(byDurationBetween, FlightInformation.class);
  }

  //  4) Implement: Find all flights that are on time and relate to a city.
  //  Means the city can be in the departure-airport location or the destination-airport location and the flight must not be delayed
  //  Question: Fetch the endpoint with city = Rome. Which flights related to Rome are not delayed?
  public List<FlightInformation> findRelatedToCityAndNotDelayed(String city) {
    Query relatedNotDelayed = new Query();

    return this.mongoTemplate.find(relatedNotDelayed, FlightInformation.class);
  }
}