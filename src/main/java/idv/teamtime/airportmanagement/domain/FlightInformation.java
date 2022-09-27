package idv.teamtime.airportmanagement.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
  private boolean isDelayed;
  private int durationMin;
  private LocalDate departureDate;
  private Aircraft aircraft;
  @Transient
  private LocalDate createdAt;

  private String description;


  public FlightInformation() {
    this.createdAt = LocalDate.now();
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

  public boolean isDelayed() {
    return isDelayed;
  }

  public void setDelayed(boolean delayed) {
    isDelayed = delayed;
  }

  public int getDurationMin() {
    return durationMin;
  }

  public void setDurationMin(int durationMin) {
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

  public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
