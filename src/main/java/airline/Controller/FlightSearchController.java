package airline.Controller;

import airline.Model.Flight;
import airline.Model.Location;
import airline.Model.SearchCriteria;
import airline.Model.TravelClassType;
import airline.Repository.LocationRepository;
import airline.Services.FlightService;
import airline.Utility.dataUploader;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    FlightService flightService;

    @Autowired
    LocationRepository locationRepository;

    @RequestMapping(value="/")
    public String welcomeMessage(Model newModel) {
        newModel.addAttribute("Sources", locationRepository.getLocations());
        newModel.addAttribute("Destinations",locationRepository.getLocations());
        newModel.addAttribute("travelClasses", TravelClassType.values());
        newModel.addAttribute("searchCriteria", new SearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
    public String searchSubmit(@ModelAttribute(value="searchCriteria")SearchCriteria searchCriteria, Model model) {
        System.out.println(searchCriteria.getSource() + searchCriteria.getDestination());
        List<Flight> result = flightService.findFlights(searchCriteria);

        System.out.println(result.size());
        model.addAttribute("flights",result);
        return "SearchResult";
    }
}
