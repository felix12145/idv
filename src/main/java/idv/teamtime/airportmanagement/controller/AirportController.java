package idv.teamtime.airportmanagement.controller;

import idv.teamtime.airportmanagement.domain.Airport;
import idv.teamtime.airportmanagement.service.AirportService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/airports")
public class AirportController {

  private final AirportService airportService;

  public AirportController(AirportService airportService) {
    this.airportService = airportService;
  }

  @GetMapping("/{id}")
  public Airport findById(@PathVariable String id) {
    return airportService.findById(id);
  }

  @PostMapping("/create")
  public Airport createAirport(@RequestBody Airport airport) {
    return airportService.createAirport(airport);
  }

  @PutMapping("/{id}/update")
  public Airport updateAirport(@PathVariable String id, @RequestBody Airport airport) {
    return airportService.updateAirport(id, airport);
  }

  @DeleteMapping("/{id}/delete")
  public Long removeAirportById(@PathVariable String id) {
    return airportService.deleteAirport(id);
  }

  @DeleteMapping("/deleteAll")
  public Integer removeAirports() {
    return airportService.deleteAll();
  }
}
