package idv.teamtime.airportmanagement.domain;

import java.time.LocalDate;
import java.time.LocalTime;
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
  private String departureCity;
  @Field("destination")
  @Indexed
  private String destinationCity;
  private FlightType type;
  private boolean isDelayed;
  private int durationMin;
  private LocalTime departureDate;
  private Aircraft aircraft;
  @Transient
  private LocalDate createdAt;


  public FlightInformation() {
    this.createdAt = LocalDate.now();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDepartureCity() {
    return departureCity;
  }

  public void setDepartureCity(String departureCity) {
    this.departureCity = departureCity;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
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

  public LocalTime getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(LocalTime departureDate) {
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
}
