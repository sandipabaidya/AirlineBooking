package airline.Services;
import airline.Model.FlightSchedules;
import airline.Utility.dataUploader;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static airline.Services.FlightService.*;
import static org.junit.Assert.*;

/**
 * Created by Sandipa on 9/5/2017.
 */


public class TestFlightService {
    private FlightService flightService;

    @Before
    public void setUp(){
        String flightInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\FlightDetails";
        String locationInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\locations.csv";
        flightService = new FlightService(dataUploader.LoadFlights(flightInfoFileName),
                dataUploader.loadLocations(locationInfoFileName));
    }

    @Test
    public void ShouldGetIfDepartureDateIsNOTGiven(){
        List<FlightSchedules> matchedFights = new ArrayList<FlightSchedules>();
        Optional<LocalDate> date=null;
        matchedFights = flightService.getFlights().stream()
                .filter(filterByDate(date))
                .collect(Collectors.toList());

        System.out.println(matchedFights.size());
    }

    @Test
    public void ShouldGetIfDepartureDateIsGiven(){
        List<FlightSchedules> matchedFights = new ArrayList<FlightSchedules>();
        Optional<LocalDate> date=Optional.ofNullable(LocalDate.parse("2017-09-07", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        matchedFights = flightService.getFlights().stream()
                .filter(filterByDate(date))
                .collect(Collectors.toList());

        System.out.println(matchedFights.size());
    }

    @Test
    public void ShouldGetIfDepartureDateAndLocationsAreGiven(){
        List<FlightSchedules> matchedFights = new ArrayList<FlightSchedules>();
        Optional<LocalDate> date=Optional.ofNullable(LocalDate.parse("2017-09-07", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        matchedFights = flightService.getFlights().stream()
                .filter(filterByDate(date))
                .filter(filterBySourceAndDestination("PUN", "CHE"))
                .collect(Collectors.toList());

        System.out.println(matchedFights.size());
    }
}
