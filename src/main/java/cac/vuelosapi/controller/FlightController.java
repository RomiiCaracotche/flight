package cac.vuelosapi.controller;

import cac.vuelosapi.model.Flight;
import cac.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightService service;

    @GetMapping
    public List<Flight> getFlights(){
        return service.getFlights();
    }

    @GetMapping(value = "/{id}")
    public Flight getFlightById(@PathVariable Long id){
        return service.getFlightById(id);
    }

    @PostMapping
    public Boolean createFlight(@RequestBody Flight flight){
        return service.createFlight(flight);
    }

    @PatchMapping(value="/{id}")
    public Boolean updateFlight(@PathVariable Long id, @RequestBody Flight flight){
        return service.updateFlight(id, flight);
    }

    @DeleteMapping(value = "/{id}")
    public Boolean deleteFlight(@PathVariable Long id){
        return service.deleteFlight(id);
    }

}
