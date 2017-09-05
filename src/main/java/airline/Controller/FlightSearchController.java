package airline.Controller;

import airline.Model.Flight;
import airline.Model.FlightSchedules;
import airline.Model.Location;
import airline.Model.SearchCriteria;
import airline.Services.FlightService;
import airline.Utility.dataUploader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Sandipa on 9/3/2017.
 */
@Controller
public class FlightSearchController {

    String flightInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\FlightDetails";
    String locationInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\locations.csv";
    private FlightService flights = new FlightService(dataUploader.LoadFlights(flightInfoFileName),
            dataUploader.loadLocations(locationInfoFileName));
//locationInfoFileName
    @RequestMapping(value="/")
    public String welcomeMessage(Model newModel) {
        List<Location> sourceCities = flights.getSourceLocations();
        List<Location> destinationCities = flights.getDestinationLocations();
        newModel.addAttribute("Sources", sourceCities);
        newModel.addAttribute("Destinations",destinationCities);
        newModel.addAttribute("searchCriteria", new SearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
    public String searchSubmit(@ModelAttribute(value="searchCriteria")SearchCriteria searchCriteria, Model model) {
        System.out.println(searchCriteria.getSource() + searchCriteria.getDestination());
        List<FlightSchedules> result = flights.findFlights(searchCriteria);

        System.out.println(result.size());
        model.addAttribute("flightSchedules",result);
        return "SearchResult";
    }
}
