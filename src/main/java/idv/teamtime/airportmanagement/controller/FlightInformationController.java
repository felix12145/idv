package idv.teamtime.airportmanagement.controller;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import idv.teamtime.airportmanagement.service.FlightInformationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/flights")
public class FlightInformationController {

  private final FlightInformationService flightInformationService;

  public FlightInformationController(FlightInformationService flightInformationService) {
    this.flightInformationService = flightInformationService;
  }

  @GetMapping("/all")
  public List<FlightInformation> findAll() {
    return flightInformationService.findAll();
  }

  @GetMapping("international/{departureCity}")
  public List<FlightInformation> findInternationFlightsByDeparture(
      @PathVariable("departureCity") String departure) {
    return flightInformationService.findInternationFlightsByDeparture(departure);
  }

  @GetMapping("duration/{durationMin}/{durationMax}")
  public List<FlightInformation> findFlightsByDuration(
      @PathVariable("durationMin") int durationMin,
      @PathVariable("durationMax") int durationMax) {

    return flightInformationService.findByDuration(durationMin, durationMax);
  }

  @GetMapping("relatedNotDelayed/{city}")
  public List<FlightInformation> findFlightsByDuration(
      @PathVariable("city") String city) {

    return flightInformationService.findRelatedToCityAndNotDelayed(city);
  }
}
