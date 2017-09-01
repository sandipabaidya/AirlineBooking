package airline;

import airline.Model.Airport;
import airline.Model.Flight;
import airline.Model.SearchCriteria;
import airline.Repositories.FlightCollection;
import airline.Utility.dataUploader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {
    String flightInfoFileName="C:\\TWHandson\\AirlineBooking\\AirlineBooking\\src\\main\\resources\\FlightDetails";
    private FlightCollection flights = new FlightCollection(dataUploader.populateFromCSVFile(flightInfoFileName));

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }

    @RequestMapping(value="/")
    public String welcomeMessage(Model newModel) {
        List<String> sourceCities = flights.getSourceLocations();
        List<String> destinationCities = flights.getDestinationLocations();
        newModel.addAttribute("Sources", sourceCities);
        newModel.addAttribute("Destinations",destinationCities);
        newModel.addAttribute("searchCriteria", new SearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
    public String searchSubmit(@ModelAttribute(value="searchCriteria")SearchCriteria searchCriteria, Model model) {
        System.out.println(searchCriteria.getSource() + searchCriteria.getDestination());
        List<Flight> result = flights.findFlights(searchCriteria);
        model.addAttribute("flights",result);
        return "SearchResult";
    }
}
