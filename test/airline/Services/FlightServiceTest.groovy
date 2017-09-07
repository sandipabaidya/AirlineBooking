package airline.Services

import airline.Model.Aeroplane
import airline.Model.Flight
import airline.Model.SearchCriteria
import airline.Model.TravelClass
import airline.Model.TravelClassType
import airline.Repository.FlightRepository
import org.junit.Assert
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner

import java.lang.reflect.Array
import java.time.LocalDate;

/**
 * Created by Sandipa on 9/7/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightService.class)
class FlightServiceTest{


    @MockBean
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    Flight mockFlight = new Flight("Fl01","src","dest",LocalDate.parse("2017-09-07"),
            new Aeroplane("B77",new ArrayList<TravelClass>(
                    Arrays.asList(new TravelClass(TravelClassType.ECONOMY,40),
                            new TravelClass(TravelClassType.BUSINESS,6))
            )));

    private List<Flight> listOfMockFlights = new ArrayList<>(Arrays.asList(mockFlight));


    @Test
    public void testGetFlightsBetweenCities() {
        Mockito.when(flightRepository.getFlights()).thenReturn(listOfMockFlights);

        //flightService=new FlightService();
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSource("src");
        searchCriteria.setDestination("dest");
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        searchCriteria.setRequiredSeats(2);
        List<Flight> listOfMatchingFlights = flightService.findFlights(searchCriteria);

        Assert.assertEquals(1, listOfMatchingFlights.size());
    }

    @Test
    public void testGetFlightsRuning() {
        Mockito.when(flightRepository.getFlights()).thenReturn(listOfMockFlights);

        //flightService=new FlightService();
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSource("src");
        searchCriteria.setDestination("dest");
        searchCriteria.setInputDepartureDate("2017-09-07");
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        searchCriteria.setRequiredSeats(2);
        List<Flight> listOfMatchingFlights = flightService.findFlights(searchCriteria);

        Assert.assertEquals(1, listOfMatchingFlights.size());
    }
}
