package idv.teamtime.airportmanagement.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Aircraft {

  @Id
  String id;
  private String model;
  private int nbSeats;

  public Aircraft(String id, String model, int nbSeats) {
    this.id = id;
    this.model = model;
    this.nbSeats = nbSeats;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getNbSeats() {
    return nbSeats;
  }

  public void setNbSeats(int nbSeats) {
    this.nbSeats = nbSeats;
  }
}
