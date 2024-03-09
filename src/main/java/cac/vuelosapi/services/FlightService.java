package cac.vuelosapi.services;

import cac.vuelosapi.model.Flight;
import cac.vuelosapi.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public List<Flight> getFlights() {
        return repository.findAll();
    }

    public Flight getFlightById(Long id) {
        if(repository.existsById(id)) {
            repository.findById(id).get();
        }
        return null;
    }

    public Boolean createFlight(Flight flight) {
        repository.save(flight);
        return true;
    }

    public Boolean updateFlight(Long id, Flight flight) {
        if(repository.existsById(id)) {
            Flight currentFlight = repository.findById(id).get();
            currentFlight.setOrigin(flight.getOrigin());
            currentFlight.setDestination(flight.getDestination());
            currentFlight.setPrice(flight.getPrice());
            currentFlight.setFrequency(flight.getFrequency());
            currentFlight.setDateTimeArrival(flight.getDateTimeArrival());
            currentFlight.setDateTimeExit(flight.getDateTimeExit());
            repository.save(currentFlight);
            return true;
        }
        return false;
    }

    public Boolean deleteFlight(Long id) {
        if(repository.existsById(id)) {
            Flight flight = repository.findById(id).get();
            repository.delete(flight);
            return true;
        }
        return false;
    }
}
