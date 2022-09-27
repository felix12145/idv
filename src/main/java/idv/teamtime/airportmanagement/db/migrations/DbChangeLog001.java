package idv.teamtime.airportmanagement.db.migrations;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import idv.teamtime.airportmanagement.domain.Aircraft;
import idv.teamtime.airportmanagement.domain.Airport;
import idv.teamtime.airportmanagement.domain.FlightInformation;
import idv.teamtime.airportmanagement.domain.FlightType;
import idv.teamtime.airportmanagement.domain.Location;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@ChangeLog(order = "001")
public class DbChangeLog001 {

  @ChangeSet(order = "001", id = "insertAirports", author = "Felix Herbst")
  public void seedAirports(MongoTemplate mongoTemplate) {

    Location locationRome = new Location(UUID.randomUUID().toString(), "Rome", "Italy");
    Location locationParis = new Location(UUID.randomUUID().toString(), "Paris", "France");
    Location locationCopenhagen = new Location(UUID.randomUUID().toString(), "Copenhagen",
        "Denmark");
    Location locationBerlin = new Location(UUID.randomUUID().toString(), "Berlin", "Germany");
    Location locationNewYork = new Location(UUID.randomUUID().toString(), "New York",
        "United States");
    Location locationFrance = new Location(UUID.randomUUID().toString(), "Paris", "France");
    Location locationBucharest = new Location(UUID.randomUUID().toString(), "Bucharest", "Romania");
    Location locationMadrid = new Location(UUID.randomUUID().toString(), "Madrid", "Spain");
    Location locationBarcelona = new Location(UUID.randomUUID().toString(), "Barcelona",
        "Spain");
    Location locationLasVegas = new Location(UUID.randomUUID().toString(), "Las Vegas", "Germany");
    Location locationWashington = new Location(UUID.randomUUID().toString(), "Washington",
        "United States");

    Airport rome = new Airport(UUID.randomUUID().toString(), 50, "Rome", false, locationRome);
    Airport paris = new Airport(UUID.randomUUID().toString(), 50, "Charles de Gaulle", false,
        locationParis);
    Airport copenhagen = new Airport(UUID.randomUUID().toString(), 40, "Copenhagen Airport", false,
        locationCopenhagen);
    Airport berlin = new Airport(UUID.randomUUID().toString(), 40, "BER", false, locationBerlin);
    Airport newYork = new Airport(UUID.randomUUID().toString(), 160, "New York Airport", false,
        locationNewYork);
    Airport france = new Airport(UUID.randomUUID().toString(), 160, "Paris Airport", false,
        locationFrance);

    Airport bucharest = new Airport(UUID.randomUUID().toString(), 160, "Bucharest Airport", false,
        locationBucharest);
    Airport madrid = new Airport(UUID.randomUUID().toString(), 160, "Madrid Airport", false,
        locationMadrid);
    Airport barcelona = new Airport(UUID.randomUUID().toString(), 160, "Barcelona Airport", false,
        locationBarcelona);
    Airport lasVegas = new Airport(UUID.randomUUID().toString(), 160, "Las Vegas Airport", false,
        locationLasVegas);
    Airport washington = new Airport(UUID.randomUUID().toString(), 160, "Washington Airport", false,
        locationWashington);
    List<Airport> airports = Arrays.asList(rome, paris, copenhagen, berlin, newYork, france,
        bucharest, madrid, barcelona, lasVegas, washington);
    mongoTemplate.insertAll(airports);

    System.out.println("DB Migrations - ChangeLog 001, ChangeSet 001");
  }


  @ChangeSet(order = "002", id = "insertAircrafts", author = "Felix Herbst")
  public void insertAircrafts(MongoTemplate mongoTemplate) {
    List<Aircraft> aircrafts = Arrays.asList(
        new Aircraft(UUID.randomUUID().toString(), "A734", 300),
        new Aircraft(UUID.randomUUID().toString(), "A737", 180),
        new Aircraft(UUID.randomUUID().toString(), "A319", 150),
        new Aircraft(UUID.randomUUID().toString(), "A320", 170),
        new Aircraft(UUID.randomUUID().toString(), "A321 Neo", 200));
    mongoTemplate.insertAll(aircrafts);

    System.out.println("DB Migrations - ChangeLog 001, ChangeSet 002");
  }

  @ChangeSet(order = "003", id = "insertFlightInformation", author = "Felix Herbst")
  public void insertFlightInformation(MongoTemplate mongoTemplate) {
    Airport rome = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Rome")),
        Airport.class);
    Airport paris = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Paris Airport")),
        Airport.class);
    Airport copenhagen = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("Copenhagen Airport")),
        Airport.class);
    Airport berlin = mongoTemplate.findOne(Query.query(Criteria.where("name").is("BER")),
        Airport.class);
    Airport newYork = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("New York Airport")),
        Airport.class);
    Airport bucharest = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("Bucharest Airport")),
        Airport.class);
    Airport madrid = mongoTemplate.findOne(Query.query(Criteria.where("name").is("Madrid Airport")),
        Airport.class);
    Airport barcelona = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("Barcelona Airport")),
        Airport.class);
    Airport lasVegas = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("Las Vegas Airport")),
        Airport.class);
    Airport washington = mongoTemplate.findOne(
        Query.query(Criteria.where("name").is("Washington Airport")),
        Airport.class);

    Aircraft A737 = mongoTemplate.findOne(Query.query(Criteria.where("model").is("A737")),
        Aircraft.class);
    Aircraft A734 = mongoTemplate.findOne(Query.query(Criteria.where("model").is("A734")),
        Aircraft.class);
    Aircraft A320 = mongoTemplate.findOne(Query.query(Criteria.where("model").is("A320")),
        Aircraft.class);
    Aircraft A319 = mongoTemplate.findOne(Query.query(Criteria.where("model").is("A319")),
        Aircraft.class);
    Aircraft A321Neo = mongoTemplate.findOne(Query.query(Criteria.where("model").is("A321 Neo")),
        Aircraft.class);

    FlightInformation flightOne = new FlightInformation();
    flightOne.setDelayed(false);
    flightOne.setDepartureAirport(rome);
    flightOne.setDestinationAirport(paris);
    flightOne.setDepartureDate(LocalDate.of(2022, 9, 23));
    flightOne.setType(FlightType.International);
    flightOne.setDurationMin(80);
    flightOne.setAircraft(A737);
    flightOne.setDescription("Flight from Rome to Paris");

    FlightInformation flightTwo = new FlightInformation();
    flightTwo.setDelayed(false);
    flightTwo.setDepartureAirport(newYork);
    flightTwo.setDestinationAirport(copenhagen);
    flightTwo.setDepartureDate(LocalDate.of(2022, 9, 25));
    flightTwo.setType(FlightType.International);
    flightTwo.setDurationMin(600);
    flightTwo.setAircraft(A734);
    flightTwo.setDescription("Flight from New York to Copenhagen");

    FlightInformation flightThree = new FlightInformation();
    flightThree.setDelayed(true);
    flightThree.setDepartureAirport(berlin);
    flightThree.setDestinationAirport(bucharest);
    flightThree.setDepartureDate(LocalDate.of(2022, 9, 27));
    flightThree.setType(FlightType.International);
    flightThree.setDurationMin(150);
    flightThree.setAircraft(A320);

    FlightInformation flightFour = new FlightInformation();
    flightFour.setDelayed(true);
    flightFour.setDepartureAirport(madrid);
    flightFour.setDestinationAirport(barcelona);
    flightFour.setDepartureDate(LocalDate.of(2022, 9, 27));
    flightFour.setType(FlightType.Internal);
    flightFour.setDurationMin(120);
    flightFour.setAircraft(A321Neo);

    FlightInformation flightFive = new FlightInformation();
    flightFive.setDelayed(false);
    flightFive.setDepartureAirport(lasVegas);
    flightFive.setDestinationAirport(washington);
    flightFive.setDepartureDate(LocalDate.of(2022, 9, 28));
    flightFive.setType(FlightType.Internal);
    flightFive.setDurationMin(400);
    flightFive.setAircraft(A319);
    flightTwo.setDescription("Flight from Las Vegas to Washington via Paris");

    FlightInformation flightSix = new FlightInformation();
    flightSix.setDelayed(false);
    flightSix.setDepartureAirport(bucharest);
    flightSix.setDestinationAirport(rome);
    flightSix.setDepartureDate(LocalDate.of(2022, 9, 28));
    flightSix.setType(FlightType.International);
    flightSix.setDurationMin(110);
    flightSix.setAircraft(A321Neo);

    List<FlightInformation> flights = Arrays.asList(flightOne, flightTwo, flightThree, flightFour,
        flightFive, flightSix);
    mongoTemplate.insertAll(flights);
  }
}
