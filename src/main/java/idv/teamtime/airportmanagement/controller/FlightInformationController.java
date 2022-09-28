package idv.teamtime.airportmanagement.controller;

import idv.teamtime.airportmanagement.domain.FlightInformation;
import idv.teamtime.airportmanagement.repositories.FlightInformationRepository;
import idv.teamtime.airportmanagement.service.FlightInformationService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/flights")
public class FlightInformationController {
  private final FlightInformationRepository flightInformationRepository;

  public FlightInformationController(FlightInformationRepository flightInformationRepository) {
    this.flightInformationRepository = flightInformationRepository;
  }

  @GetMapping("/all")
  public List<FlightInformation> findAll() {
    return flightInformationRepository.findAll();
  }

  @GetMapping("international/{departureCity}")
  public List<FlightInformation> findInternationalFlightsByDeparture(
      @PathVariable("departureCity") String departure) {

    return  flightInformationRepository.findInternationalFlightsByDeparture(departure);
  }

  @GetMapping("duration/{durationMin}/{durationMax}")
  public List<FlightInformation> findFlightsByDuration(
      @PathVariable("durationMin") int durationMin,
      @PathVariable("durationMax") int durationMax) {

    return flightInformationRepository.findByDuration(durationMin, durationMax);
  }

  @GetMapping("relatedNotDelayed/{city}")
  public List<FlightInformation> findFlightsByDuration(
      @PathVariable("city") String city) {

    return flightInformationRepository.findRelatedToCityAndNotDelayed(city);
  }
}
