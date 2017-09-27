package airline.Repository;

import airline.Model.Flight;
import airline.Utility.dataUploader;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sandipa on 9/7/2017.
 */

@Repository
public class FlightRepository {
    private List<Flight> flights;

    public FlightRepository() {
        String flightInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\FlightDetails";
        flights = dataUploader.LoadFlights(flightInfoFileName);
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
