package airline.Repository;

import airline.Model.Flight;
import airline.Utility.dataUploader;
import org.springframework.core.io.*;
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
        flights = dataUploader.LoadFlights(flightInfoFileName);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
