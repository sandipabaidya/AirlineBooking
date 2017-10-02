package net.sandipabaidya.airlinebooking.controller;

import net.sandipabaidya.airlinebooking.model.TravelClassType;
import net.sandipabaidya.airlinebooking.model.viewmodels.SearchCriteria;
import net.sandipabaidya.airlinebooking.model.viewmodels.SearchResponse;
import net.sandipabaidya.airlinebooking.repository.LocationRepository;
import net.sandipabaidya.airlinebooking.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sandipa on 9/3/2017.
 */
@Controller
public class FlightSearchController {

    @Autowired
    FlightService flightService;

    @Autowired
    LocationRepository locationRepository;


    @RequestMapping(value = "/")
    public String welcomeMessage(Model newModel) {
        newModel.addAttribute("Sources", locationRepository.getLocations());
        newModel.addAttribute("Destinations", locationRepository.getLocations());
        newModel.addAttribute("travelClasses", TravelClassType.values());
        newModel.addAttribute("searchCriteria", new SearchCriteria());
        return "flightSearch";
    }

    @RequestMapping(value = "/searchFlight", method = RequestMethod.POST)
    public String searchSubmit(@ModelAttribute(value = "searchCriteria") SearchCriteria searchCriteria, Model model) {
        //PricingRulesRepsitory pricingRulesRepsitory = new PricingRulesRepsitory();
        SearchResponse response = flightService.SearchFlights(searchCriteria);

        if (response.isSearchSuccess())
            model.addAttribute("flights", response.getMatchedFights());
        else {
            model.addAttribute("message", response.getMessage());
        }
        return "SearchResult";
    }


}
