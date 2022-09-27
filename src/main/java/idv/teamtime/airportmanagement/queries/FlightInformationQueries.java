package idv.teamtime.airportmanagement.queries;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import idv.teamtime.airportmanagement.domain.FlightType;
import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class FlightInformationQueries {

  private MongoTemplate mongoTemplate;

  public FlightInformationQueries(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  // TODO: Implement the following queries

  //  1) Find all flights with paging and sorting
  public List<FlightInformation> findAll(String field, int pageNb, int pageSize) {
    Query allPagedAndOrdered = new Query()
        .with(Sort.by(Direction.ASC, field))
        .with(PageRequest.of(pageNb, pageSize));

    return this.mongoTemplate.find(allPagedAndOrdered, FlightInformation.class);
  }

  //  2) Find by flight id
  public FlightInformation findSingleById(String id) {
    return this.mongoTemplate.findById(id, FlightInformation.class);
  }

  //  3) Count all international flights
  public long countInternational() {
    Query countInternational = Query.query(Criteria.where("type")
        .is(FlightType.International));

    return this.mongoTemplate.count(countInternational, FlightInformation.class);
  }

  //  4) Find  all flights by departure city
  public List<FlightInformation> findByDeparture(String departure) {
    Query departureQuery = Query.query(Criteria.where("departure")
        .is(departure));

    return this.mongoTemplate.find(departureQuery, FlightInformation.class);
  }

  //  5) Find all flights by duration between min and max
  public List<FlightInformation> findByDuration(int minDuration, int maxDuration) {
    var durationMinField = "durationMin";
    Query byDurationBetween = Query.query(Criteria.where(durationMinField)
            .gte(minDuration)
            .lte(minDuration))
        .with(Sort.by(Direction.DESC, durationMinField));

    return this.mongoTemplate.find(byDurationBetween, FlightInformation.class);
  }

  //  6) Find all flights delayed at a particular departure departure
  public List<FlightInformation> findDelayedFlightsAtCity(String departure) {
    Query durationQuery = Query.query(Criteria
        .where("departure").is(departure)
        .and("isDelayed").is(true));

    return this.mongoTemplate.find(durationQuery, FlightInformation.class);
  }

  //  7) Find all flights that are on time and relate to a city
  public List<FlightInformation> findRelatedToCityAndNotDelayed(String city) {
    Query relatedNotDelayed = Query.query(new Criteria()
        .orOperator(
            Criteria.where("departure").is(city),
            Criteria.where("destination").is(city))
        .andOperator(Criteria.where("isDelayed").is(false)));

    return this.mongoTemplate.find(relatedNotDelayed, FlightInformation.class);
  }

  //  8) Find by aircraft model
  public List<FlightInformation> findByAircraft(String model) {
    Query aircraftQuery = Query.query(Criteria.where("aircraft.model").is(model));

    return this.mongoTemplate.find(aircraftQuery, FlightInformation.class);
  }
}