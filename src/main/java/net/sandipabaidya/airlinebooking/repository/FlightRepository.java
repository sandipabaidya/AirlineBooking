package net.sandipabaidya.airlinebooking.repository;

import net.sandipabaidya.airlinebooking.model.Flight;
import net.sandipabaidya.airlinebooking.utility.DataUploader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

/**
 * Created by Sandipa on 9/7/2017.
 */

@Repository
public class FlightRepository {
    private List<Flight> flights;

    public FlightRepository() throws Exception {

        Resource resource = new ClassPathResource("FlightDetails");
        File flightInfoFileName = resource.getFile();
        flights = DataUploader.LoadFlights(flightInfoFileName);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
