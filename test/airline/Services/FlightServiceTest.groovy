package airline.Services

import airline.Model.Aeroplane
import airline.Model.Flight
import airline.Model.PricingRuleModels.EconomicPricingRuleModel
import airline.Model.ViewModels.FlightView
import airline.Model.ViewModels.SearchCriteria
import airline.Model.TravelClass
import airline.Model.TravelClassType
import airline.Repository.FlightRepository
import airline.Repository.PricingRulesRepsitory
import org.junit.Assert
import org.junit.Before
import org.junit.Test;
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner

import java.time.LocalDate

/**
 * Created by Sandipa on 9/7/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = FlightService.class)
class FlightServiceTest{
    @Autowired
    FlightService flightService


    @MockBean
    FlightRepository flightRepository;


    @Before
    public void setUp()
    {
        Mockito.when(flightRepository.getFlights()).thenReturn(listOfMockFlights);

    }



    Flight mockFlight = new Flight("Fl01","src","dest",LocalDate.parse("2017-09-07"),
            new Aeroplane("B77",new ArrayList<TravelClass>(
                    Arrays.asList(new TravelClass(TravelClassType.ECONOMY,40,400),
                            new TravelClass(TravelClassType.BUSINESS,6,6000))
            )));

    private List<Flight> listOfMockFlights = new ArrayList<>(Arrays.asList(mockFlight));

    @Test
    public void testGetFlightsBetweenCities() {
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSource("src");
        searchCriteria.setDestination("dest");
        searchCriteria.setTravelClassType(TravelClassType.BUSINESS);
        searchCriteria.setRequiredSeats(2);
        List<FlightView> listOfMatchingFlights = flightService.findFlights(searchCriteria);

        Assert.assertEquals(1, listOfMatchingFlights.size());
    }




    @Test
    public void ShouldReturn1ZeroIfClassIsNotAvailable()
    {
        TravelClass travelClass=new TravelClass(TravelClassType.ECONOMY, 6,6000);
        Aeroplane aeroplane = new Aeroplane("Boeing77");
        aeroplane.AddTravelClass(travelClass);
        Flight flight =new Flight("fl01","blr","del",LocalDate.parse("2017-09-06"),aeroplane);

        Assert.assertEquals(0,
                flight.getBaseFare(TravelClassType.BUSINESS),0.001);

    }


}
