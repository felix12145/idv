package idv.teamtime.airportmanagement.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("flights")
public class FlightInformation {

  @Id
  private String id;
  @Field("departure")
  @Indexed
  private Airport departureAirport;
  @Field("destination")
  @Indexed
  private Airport destinationAirport;
  private FlightType type;
  private Boolean isDelayed;
  private Integer durationMin;
  private LocalDate departureDate;
  private Aircraft aircraft;
  private String description;

  public FlightInformation(String id, Airport departureAirport, Airport destinationAirport,
      FlightType type, Boolean isDelayed, Integer durationMin, LocalDate departureDate,
      Aircraft aircraft,
      String description) {
    this.id = id;
    this.departureAirport = departureAirport;
    this.destinationAirport = destinationAirport;
    this.type = type;
    this.isDelayed = isDelayed;
    this.durationMin = durationMin;
    this.departureDate = departureDate;
    this.aircraft = aircraft;
    this.description = description;
  }

  public FlightInformation() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Airport getDepartureAirport() {
    return departureAirport;
  }

  public void setDepartureAirport(Airport departureAirport) {
    this.departureAirport = departureAirport;
  }

  public Airport getDestinationAirport() {
    return destinationAirport;
  }

  public void setDestinationAirport(Airport destinationAirport) {
    this.destinationAirport = destinationAirport;
  }

  public FlightType getType() {
    return type;
  }

  public void setType(FlightType type) {
    this.type = type;
  }

  public Boolean isDelayed() {
    return isDelayed;
  }

  public void setDelayed(Boolean delayed) {
    isDelayed = delayed;
  }

  public Integer getDurationMin() {
    return durationMin;
  }

  public void setDurationMin(Integer durationMin) {
    this.durationMin = durationMin;
  }

  public LocalDate getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalDate departureDate) {
    this.departureDate = departureDate;
  }

  public Aircraft getAircraft() {
    return aircraft;
  }

  public void setAircraft(Aircraft aircraft) {
    this.aircraft = aircraft;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
