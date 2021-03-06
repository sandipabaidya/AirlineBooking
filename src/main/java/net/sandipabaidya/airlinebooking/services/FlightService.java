package net.sandipabaidya.airlinebooking.services;

import net.sandipabaidya.airlinebooking.model.Flight;
import net.sandipabaidya.airlinebooking.model.viewmodels.FlightView;
import net.sandipabaidya.airlinebooking.model.viewmodels.SearchCriteria;
import net.sandipabaidya.airlinebooking.model.viewmodels.SearchResponse;
import net.sandipabaidya.airlinebooking.repository.FlightRepository;
import net.sandipabaidya.airlinebooking.repository.PricingRulesRepsitory;
import net.sandipabaidya.airlinebooking.utility.FlightToFlightViewTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Sandipa on 9/1/2017.
 */
@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PricingRulesRepsitory pricingRulesRepsitory;

    public SearchResponse SearchFlights(SearchCriteria searchCriteria) {
        SearchResponse searchResponse = new SearchResponse();

        List<FlightView> flightViews = findFlights(searchCriteria).stream()
            .map(flight -> convertToFlightViewWithPrice(flight, searchCriteria))
            .collect(Collectors.toList());

        searchResponse.setSearchSuccess(flightViews.size() > 0);
        searchResponse.setMatchedFights(flightViews);
        if (flightViews.size() > 0)
            searchResponse.setMessage("No Flight Found");

        return searchResponse;
    }

    private List<Flight> findFlights(SearchCriteria searchCriteria) {
        List<Flight> flights = flightRepository.getFlights();


        List<Flight> matchedFights = flights.stream()
            .filter(flight -> flight.isRunBetweenCities(searchCriteria.getSource(), searchCriteria.getDestination()))
            .filter(flight -> searchCriteria.getDepartureDate() == null ||
                flight.isDepartingOnDate(searchCriteria.getDepartureDate()))
            .filter(flight -> flight.isSeatsAvailableInTravelClass(searchCriteria.getTravelClassType(), searchCriteria.getRequiredSeats()))
            .collect(Collectors.toList());


        return matchedFights;
    }

    private FlightView convertToFlightViewWithPrice(Flight flight, SearchCriteria searchCriteria) {

        FlightToFlightViewTransformer transformer = new FlightToFlightViewTransformer();
        FlightView flightView = transformer.transform(flight);

        //Calculate and Set Price
        flightView.setFare(flight.getTotalFare(searchCriteria.getTravelClassType(), searchCriteria.getRequiredSeats(), Optional.ofNullable(pricingRulesRepsitory)));

        return flightView;
    }
}
