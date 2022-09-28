package idv.teamtime.airportmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Airport {
  @Id
  String id;
  Integer flightsPerDay;
  String name;
  Boolean closed;
  Location location;

  public Airport(String id, Integer flightsPerDay, String name, Boolean closed, Location location) {
    this.id=id;
    this.flightsPerDay = flightsPerDay;
    this.name = name;
    this.closed = closed;
    this.location = location;
  }

  public Boolean getClosed() {
    return closed;
  }

  public void setClosed(Boolean closed) {
    this.closed = closed;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getFlightsPerDay() {
    return flightsPerDay;
  }

  public void setFlightsPerDay(Integer flightsPerDay) {
    this.flightsPerDay = flightsPerDay;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }
}
